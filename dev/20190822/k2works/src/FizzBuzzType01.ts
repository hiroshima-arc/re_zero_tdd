import { FizzBuzz } from "./FizzBuzz";

export class FizzBuzzType01 {
  // tslint:disable-next-line: variable-name
  private _number: number;

  constructor(input: number) {
    this._number = input;
  }

  public generate(): string {
    const isFizz: boolean = this._number % 3 === 0;
    const isBuzz: boolean = this._number % 5 === 0;

    if (isFizz && isBuzz) {
      return FizzBuzz.FIZZ_BUZZ;
    }
    if (isFizz) {
      return FizzBuzz.FIZZ;
    }
    if (isBuzz) {
      return FizzBuzz.BUZZ;
    }

    return this._number.toString();
  }
}
