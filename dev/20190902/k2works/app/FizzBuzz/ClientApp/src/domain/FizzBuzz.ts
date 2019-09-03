export class FizzBuzz {
  public static print1To100(): any[] {
    const list = [];
    for (let i = 1; i <= 100; i++) {
      list[i - 1] = i;
    }
    return list;
  }

  public static generate(number: number) {
    let result = number.toString();
    if (number % 3 === 0) {
      result = "Fizz";
    }
    return result;
  }
}
