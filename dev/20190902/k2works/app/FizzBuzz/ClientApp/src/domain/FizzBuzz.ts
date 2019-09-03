export class FizzBuzz {
  public static generateList(): string[] {
    const list: string[] = [];
    for (let i = 1; i <= 100; i++) {
      list.push(FizzBuzz.generate(i));
    }
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
