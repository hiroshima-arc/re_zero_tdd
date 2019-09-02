import { IFizzBuzzType } from "../../Domain/Type/IFizzBuzzType";
import { IFizzBuzzCommand } from "./IFizzBuzzCommand";

export class FizzBuzzValueCommand implements IFizzBuzzCommand {
  // tslint:disable-next-line: variable-name
  private _type: IFizzBuzzType;

  constructor(type: IFizzBuzzType) {
    this._type = type;
  }
  public execute(
    input: number
  ): import("../../Domain/Model/IFizzBuzz").IFizzBuzz {
    return this._type.generate(input);
  }
}
