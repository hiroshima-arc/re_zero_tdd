import { FizzBuzz } from "./FizzBuzz";
import { FizzBuzzType } from "./FizzBuzzType";

export class FizzBuzzType01 extends FizzBuzzType {
  public generate(input: number): string {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;

    if (isFizz && isBuzz) {
      return FizzBuzzType.FIZZ_BUZZ;
    }
    if (isFizz) {
      return FizzBuzzType.FIZZ;
    }
    if (isBuzz) {
      return FizzBuzzType.BUZZ;
    }

    return input.toString();
  }
}
