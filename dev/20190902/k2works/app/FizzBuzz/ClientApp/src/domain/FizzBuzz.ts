export class FizzBuzz {
  public static generateList(): any[] {
    const list = [];
    for (let i = 1; i <= 100; i++) {
      list[i - 1] = i;
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
