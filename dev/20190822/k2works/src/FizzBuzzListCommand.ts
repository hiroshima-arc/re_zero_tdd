import { FizzBuzzList } from "./Domain/Model/FizzBuzzList";
import { IFizzBuzz } from "./Domain/Model/IFizzBuzz";
import { IFizzBuzzType } from "./Domain/Type/IFizzBuzzType";
import { IFizzBuzzCommand } from "./IFizzBuzzCommand";

export class FizzBuzzListCommand implements IFizzBuzzCommand {
  // tslint:disable-next-line: variable-name
  private _type: IFizzBuzzType;
  // tslint:disable-next-line: variable-name
  private _list: FizzBuzzList;

  constructor(type: IFizzBuzzType) {
    this._type = type;
  }

  public execute(input: number): import("./Domain/Model/IFizzBuzz").IFizzBuzz {
    if (input < 0) {
      throw new Error("FizzBuzzList can't generate by minus number");
    }
    this._list = new FizzBuzzList([]);

    IFizzBuzz.range(1, input).forEach(
      i => (this._list = this._list.add(this._type.generate(i)))
    );

    return this._list;
  }
}
