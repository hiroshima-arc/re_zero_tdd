import { FizzBuzzType01 } from "./FizzBuzzType01";
import { FizzBuzzType02 } from "./FizzBuzzType02";
import { FizzBuzzType03 } from "./FizzBuzzType03";

export class FizzBuzz {
  public get list(): string[] {
    return this._list;
  }
  public static readonly MAX_NUMBER: number = 100;
  public static readonly FIZZ: string = "Fizz";
  public static readonly BUZZ: string = "Buzz";
  public static readonly FIZZ_BUZZ: string = "FizzBuzz";
  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);

  // tslint:disable-next-line: variable-name
  private _list: string[];
  // tslint:disable-next-line: variable-name
  private _type01: FizzBuzzType01;
  // tslint:disable-next-line: variable-name
  private _type02: FizzBuzzType02;
  // tslint:disable-next-line: variable-name
  private _type03: FizzBuzzType03;

  constructor(type: number) {
    switch (type) {
      case 1:
        this._type01 = new FizzBuzzType01();
      case 2:
        this._type02 = new FizzBuzzType02();
      case 3:
        this._type03 = new FizzBuzzType03();
    }
  }

  public generate(input: number, type: number = 1) {
    switch (type) {
      case 1:
        return this._type01.generate(input);
      case 2:
        return this._type02.generate(input);
      case 3:
        return this._type03.generate(input);
      default:
        return this._type01.generate(input);
    }
  }

  public generateList(type: number = 1): void {
    this._list = FizzBuzz.range(1, FizzBuzz.MAX_NUMBER).map(i =>
      this.generate(i, type)
    );
  }
}
