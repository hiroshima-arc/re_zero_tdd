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
  public static generateList(): string[] {
    const list: string[] = [];
    for (let i: number = 1; i <= 100; i++) {
      const value: string = FizzBuzz.generate(i);
      list.push(value);
    }
    return list;
  }
}
