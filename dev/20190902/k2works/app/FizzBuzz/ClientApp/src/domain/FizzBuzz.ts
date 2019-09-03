export class FizzBuzz {
  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);

  public static generateList(): string[] {
    return FizzBuzz.range(1, 100).map(i => FizzBuzz.generate(i));
  }

  public static generate(input: number) {
    const isFizz: boolean = input % 3 === 0;
    const isBuzz: boolean = input % 5 === 0;
    if (isFizz && isBuzz) {
      return "FizzBuzz";
    }
    if (isFizz) {
      return "Fizz";
    }
    if (isBuzz) {
      return "Buzz";
    }
    return input.toString();
  }
}
