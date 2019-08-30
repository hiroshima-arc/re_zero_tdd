import { FizzBuzzType } from "./FizzBuzzType";
import { FizzBuzzType01 } from "./FizzBuzzType01";
import { FizzBuzzType02 } from "./FizzBuzzType02";
import { FizzBuzzType03 } from "./FizzBuzzType03";

export class FizzBuzz {
  public get list(): string[] {
    return this._list;
  }
  public static readonly MAX_NUMBER: number = 100;
  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);

  // tslint:disable-next-line: variable-name
  private _list: string[];
  // tslint:disable-next-line: variable-name
  private _type: FizzBuzzType;

  constructor(type: FizzBuzzType) {
    this._type = type;
  }

  public generate(input: number) {
    return this._type.generate(input);
  }

  public generateList(): void {
    this._list = FizzBuzz.range(1, FizzBuzz.MAX_NUMBER).map(i =>
      this.generate(i)
    );
  }
}
