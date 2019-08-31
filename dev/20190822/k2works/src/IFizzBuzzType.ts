import { FizzBuzzValue } from "./FizzBuzzValue";

export abstract class IFizzBuzzType {
  public static readonly FIZZ: string = "Fizz";
  public static readonly BUZZ: string = "Buzz";
  public static readonly FIZZ_BUZZ: string = "FizzBuzz";
  public abstract generate(input: number): FizzBuzzValue;
}
