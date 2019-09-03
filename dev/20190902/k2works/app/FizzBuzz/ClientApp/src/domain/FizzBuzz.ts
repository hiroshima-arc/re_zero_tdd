export class FizzBuzz {
  public static readonly MAX_NUMBER: number = 100;
  public static readonly FIZZ: string = "Fizz";
  public static readonly BUZZ: string = "Buzz";
  public static readonly FIZZ_BUZZ: string = FizzBuzz.FIZZ + FizzBuzz.BUZZ;

  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);

  public static generateList(): string[] {
    return FizzBuzz.range(1, this.MAX_NUMBER).map(i => FizzBuzz.generate(i));
  }

  public static generate(input: number) {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;
    if (isFizz && isBuzz) {
      return this.FIZZ_BUZZ;
    }
    if (isFizz) {
      return this.FIZZ;
    }
    if (isBuzz) {
      return this.BUZZ;
    }
    return input.toString();
  }
}
