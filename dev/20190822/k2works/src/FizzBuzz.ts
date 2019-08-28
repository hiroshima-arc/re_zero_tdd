import { FizzBuzzType01 } from "./FizzBuzzType01";

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
        return input.toString();
      case 3:
        const isFizz: boolean = input % 3 === 0;
        const isBuzz: boolean = input % 5 === 0;

        if (isFizz && isBuzz) {
          return FizzBuzz.FIZZ_BUZZ;
        }
        return input.toString();
      default:
        return this._generate(input);
    }
  }

  public generateList(type: number = 1): void {
    this._list = FizzBuzz.range(1, FizzBuzz.MAX_NUMBER).map(i =>
      this.generate(i, type)
    );
  }

  private _generate(num: number): string {
    const isFizz: boolean = num % 3 === 0;
    const isBuzz: boolean = num % 5 === 0;

    if (isFizz && isBuzz) {
      return FizzBuzz.FIZZ_BUZZ;
    }
    if (isFizz) {
      return FizzBuzz.FIZZ;
    }
    if (isBuzz) {
      return FizzBuzz.BUZZ;
    }

    return num.toString();
  }
}
