import { FizzBuzz } from "./FizzBuzz";
import { FizzBuzzType } from "./FizzBuzzType";

export class FizzBuzzType03 extends FizzBuzzType {
  public generate(input: number): string {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;

    if (isFizz && isBuzz) {
      return FizzBuzzType.FIZZ_BUZZ;
    }
    return input.toString();
  }
}
