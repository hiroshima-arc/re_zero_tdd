import { FizzBuzzValue } from "./FizzBuzzValue";
import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzz {
  public get list(): FizzBuzzValue[] {
    return this._list;
  }
  public static readonly MAX_NUMBER: number = 100;
  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);

  // tslint:disable-next-line: variable-name
  private _list: FizzBuzzValue[];
  // tslint:disable-next-line: variable-name
  private _type: IFizzBuzzType;

  constructor(type: IFizzBuzzType) {
    this._type = type;
  }

  public generate(input: number): FizzBuzzValue {
    return this._type.generate(input);
  }

  public generateList(): void {
    this._list = FizzBuzz.range(1, FizzBuzz.MAX_NUMBER).map(i =>
      this.generate(i)
    );
  }
}
