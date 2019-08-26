export class FizzBuzz {
  public static generate(num: number): any {
    if (num % 3 === 0 && num % 5 === 0) {
      return "FizzBuzz";
    }
    if (num % 3 === 0) {
      return "Fizz";
    }
    if (num % 5 === 0) {
      return "Buzz";
    }

    return num.toString();
  }
  public static generateList(): number[] {
    const list = [];
    for (let i = 1; i <= 100; i++) {
      list[i - 1] = i;
    }
    return list;
  }
}
