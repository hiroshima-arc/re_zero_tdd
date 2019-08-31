import { FizzBuzz } from "./FizzBuzz";
import { FizzBuzzList } from "./FizzBuzzList";
import { IFizzBuzzCommand } from "./IFizzBuzzCommand";
import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzzListCommand implements IFizzBuzzCommand {
  // tslint:disable-next-line: variable-name
  private _type: IFizzBuzzType;
  // tslint:disable-next-line: variable-name
  private _list: FizzBuzzList;

  constructor(type: IFizzBuzzType) {
    this._type = type;
  }

  public execute(input: number): import("./IFizzBuzz").IFizzBuzz {
    this._list = new FizzBuzzList([]);

    FizzBuzz.range(1, input).forEach(
      i => (this._list = this._list.add(this._type.generate(i)))
    );

    return this._list;
  }
}
