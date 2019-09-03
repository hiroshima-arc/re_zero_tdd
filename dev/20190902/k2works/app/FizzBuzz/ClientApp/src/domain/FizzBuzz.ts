export class FizzBuzz {
  public static generateList(): string[] {
    const list: string[] = [];
    const range = (start: number, end: number) =>
      Array.from({ length: end - start + 1 }, (v, k) => k + start);
    range(1, 100).forEach(i => {
      const value: string = FizzBuzz.generate(i);
      list.push(value);
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
