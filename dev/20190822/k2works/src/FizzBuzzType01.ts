import { FizzBuzz } from "./FizzBuzz";

export class FizzBuzzType01 {
  public generate(input: number): string {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;

    if (isFizz && isBuzz) {
      return FizzBuzz.FIZZ_BUZZ;
    }
    if (isFizz) {
      return FizzBuzz.FIZZ;
    }
    if (isBuzz) {
      return FizzBuzz.BUZZ;
    }

    return input.toString();
  }
}
