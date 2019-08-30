import { FizzBuzzType01 } from "./FizzBuzzType01";
import { FizzBuzzType02 } from "./FizzBuzzType02";
import { FizzBuzzType03 } from "./FizzBuzzType03";

export class FizzBuzzType {
  public static readonly one = new FizzBuzzType01();
  public static readonly two = new FizzBuzzType02();
  public static readonly three = new FizzBuzzType03();
}
