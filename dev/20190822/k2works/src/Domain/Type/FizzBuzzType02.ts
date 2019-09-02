import { IFizzBuzzType } from "../../Application/Service/IFizzBuzzType";
import { FizzBuzzValue } from "../Model/FizzBuzzValue";

export class FizzBuzzType02 extends IFizzBuzzType {
  public generate(input: number): FizzBuzzValue {
    return new FizzBuzzValue(input, input.toString());
  }
}
