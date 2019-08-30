import { FizzBuzz } from "./FizzBuzz";
import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzzType03 extends IFizzBuzzType {
  public generate(input: number): string {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;

    if (isFizz && isBuzz) {
      return IFizzBuzzType.FIZZ_BUZZ;
    }
    return input.toString();
  }
}
