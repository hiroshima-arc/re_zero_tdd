import { AssertionError } from "assert";
import { IFizzBuzz } from "./IFizzBuzz";

export class FizzBuzzValue implements IFizzBuzz {
  public get number(): number {
    return this._number;
  }
  public get value(): string {
    return this._value;
  }
  // tslint:disable-next-line: variable-name
  private _number: number;
  // tslint:disable-next-line: variable-name
  private _value: string;

  // tslint:disable-next-line: variable-name
  constructor(number: number, value: string) {
    if (number < 0) {
      throw new Error("FizzBuzzValue can't generate by minus number");
    }
    this._number = number;
    this._value = value;
  }
  public getValue(): string {
    return this.value;
  }
  public getList(): FizzBuzzValue[] {
    return [];
  }
}
