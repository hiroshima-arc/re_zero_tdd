export class FizzBuzz {
  public static print1To100(): number[] {
    const list = [];
    for (let i = 1; i <= 100; i++) {
      list[i - 1] = i;
    }
    return list;
  }
}
