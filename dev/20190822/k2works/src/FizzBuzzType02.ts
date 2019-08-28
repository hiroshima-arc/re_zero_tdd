import { FizzBuzzType } from "./FizzBuzzType";

export class FizzBuzzType02 extends FizzBuzzType {
  public generate(input: number): string {
    return input.toString();
  }
}
