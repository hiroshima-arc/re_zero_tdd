import { IFizzBuzzCommand } from "./IFizzBuzzCommand";
import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzzValueCommand implements IFizzBuzzCommand {
  // tslint:disable-next-line: variable-name
  private _type: IFizzBuzzType;

  constructor(type: IFizzBuzzType) {
    this._type = type;
  }
  public execute(input: number): import("./IFizzBuzz").IFizzBuzz {
    return this._type.generate(input);
  }
}
