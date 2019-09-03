export class FizzBuzz {
  public static generateList(): any[] {
    const list = [];
    for (let i = 1; i <= 100; i++) {
      list[i - 1] = i;
    }
    return list;
  }

  public static generate(input: number) {
    let result = input.toString();
    if (input % 3 === 0 && input % 5 === 0) {
      result = "FizzBuzz";
    } else if (input % 3 === 0) {
      result = "Fizz";
    } else if (input % 5 === 0) {
      result = "Buzz";
    }
    return result;
  }
}
