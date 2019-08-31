import { FizzBuzz } from "./FizzBuzz";
import { FizzBuzzValue } from "./FizzBuzzValue";
import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzzType01 extends IFizzBuzzType {
  public generate(input: number): FizzBuzzValue {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;

    if (isFizz && isBuzz) {
      return new FizzBuzzValue(input, IFizzBuzzType.FIZZ_BUZZ);
    }
    if (isFizz) {
      return new FizzBuzzValue(input, IFizzBuzzType.FIZZ);
    }
    if (isBuzz) {
      return new FizzBuzzValue(input, IFizzBuzzType.BUZZ);
    }

    return new FizzBuzzValue(input, input.toString());
  }
}
