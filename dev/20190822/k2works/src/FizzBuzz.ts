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

  public generate(input: number, type: number = 1) {
    switch (type) {
      case 1:
        return new FizzBuzzType01(input).generate();
      case 2:
        return new FizzBuzzType02(input).generate();
      case 3:
        return new FizzBuzzType03(input).generate();
      default:
        return new FizzBuzzType01(input).generate();
    }
  }

  public generateList(type: number = 1): void {
    this._list = FizzBuzz.range(1, FizzBuzz.MAX_NUMBER).map(i =>
      this.generate(i, type)
    );
  }
}
