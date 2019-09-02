import { FizzBuzzValue } from "./FizzBuzzValue";

export abstract class IFizzBuzz {
  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);
  public abstract getValue(): string;
  public abstract getList(): FizzBuzzValue[];
}
