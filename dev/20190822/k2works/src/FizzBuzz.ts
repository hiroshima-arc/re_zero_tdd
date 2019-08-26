export class FizzBuzz {
  public static generate(num: number): string {
    const isFizz: boolean = num % 3 === 0;
    const isBuzz: boolean = num % 5 === 0;

    if (isFizz && isBuzz) {
      return "FizzBuzz";
    }
    if (isFizz) {
      return "Fizz";
    }
    if (isBuzz) {
      return "Buzz";
    }

    return num.toString();
  }
  public static generateList(): any[] {
    const range = (start: number, end: number) =>
      Array.from({ length: end - start + 1 }, (v, k) => k + start);

    return range(1, 100).map(i => FizzBuzz.generate(i));
  }
}
