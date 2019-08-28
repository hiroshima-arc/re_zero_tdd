import { FizzBuzz } from "./FizzBuzz";

export class FizzBuzzType03 {
  public generate(input: number): string {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;

    if (isFizz && isBuzz) {
      return FizzBuzz.FIZZ_BUZZ;
    }
    return input.toString();
  }
}
