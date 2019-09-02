import { IFizzBuzz } from "../Service/IFizzBuzz";
import { IFizzBuzzCommand } from "../Service/IFizzBuzzCommand";
import { IFizzBuzzType } from "../Service/IFizzBuzzType";

export class FizzBuzzValueCommand implements IFizzBuzzCommand {
  // tslint:disable-next-line: variable-name
  private _type: IFizzBuzzType;

  constructor(type: IFizzBuzzType) {
    this._type = type;
  }
  public execute(input: number): IFizzBuzz {
    return this._type.generate(input);
  }
}
