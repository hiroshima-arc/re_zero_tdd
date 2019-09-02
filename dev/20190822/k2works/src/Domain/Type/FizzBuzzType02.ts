import { FizzBuzzValue } from "../Model/FizzBuzzValue";
import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzzType02 extends IFizzBuzzType {
  public generate(input: number): FizzBuzzValue {
    return new FizzBuzzValue(input, input.toString());
  }
}
