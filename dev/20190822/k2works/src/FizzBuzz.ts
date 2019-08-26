export class FizzBuzz {
  public static generate(num: number): any {
    let result: string = num.toString();

    if (num % 3 === 0) {
      result = "Fizz";
    }

    return result;
  }
  public static print1To100(): number[] {
    const list = [];
    for (let i = 1; i <= 100; i++) {
      list[i - 1] = i;
    }
    return list;
  }
}
