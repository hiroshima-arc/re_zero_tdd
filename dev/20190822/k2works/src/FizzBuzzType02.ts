import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzzType02 extends IFizzBuzzType {
  public generate(input: number): string {
    return input.toString();
  }
}
