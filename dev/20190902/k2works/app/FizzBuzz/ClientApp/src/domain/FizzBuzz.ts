export class FizzBuzz {
  public static generateList(): any[] {
    const list = [];
    for (let i = 1; i <= 100; i++) {
      list[i - 1] = i;
    }
    return list;
  }

  public static generate(input: number) {
    if (input % 3 === 0 && input % 5 === 0) {
      return "FizzBuzz";
    }
    if (input % 3 === 0) {
      return "Fizz";
    }
    if (input % 5 === 0) {
      return "Buzz";
    }
    return input.toString();
  }
}
