export class FizzBuzz {
  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);

  public static generateList(): string[] {
    const list: string[] = [];
    FizzBuzz.range(1, 100).forEach(i => {
      list.push(FizzBuzz.generate(i));
    });
    return list;
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
