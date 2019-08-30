import { FizzBuzz } from "./FizzBuzz";
import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzzType01 extends IFizzBuzzType {
  public generate(input: number): string {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;

    if (isFizz && isBuzz) {
      return IFizzBuzzType.FIZZ_BUZZ;
    }
    if (isFizz) {
      return IFizzBuzzType.FIZZ;
    }
    if (isBuzz) {
      return IFizzBuzzType.BUZZ;
    }

    return input.toString();
  }
}
