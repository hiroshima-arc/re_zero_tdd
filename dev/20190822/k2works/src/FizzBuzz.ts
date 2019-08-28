export class FizzBuzz {
  public static readonly MAX_NUMBER: number = 100;
  public static readonly FIZZ: string = "Fizz";
  public static readonly BUZZ: string = "Buzz";
  public static readonly FIZZ_BUZZ: string = "FizzBuzz";

  public static generate(input: number, type: number = 1) {
    switch (type) {
      case 1:
        return this._generate(input);
      case 2:
        return input.toString();
      case 3:
        const isFizz: boolean = input % 3 === 0;
        const isBuzz: boolean = input % 5 === 0;

        if (isFizz && isBuzz) {
          return this.FIZZ_BUZZ;
        }
        return input.toString();
      default:
        return this._generate(input);
    }
  }

  public static generateList(type: number = 1): string[] {
    const range = (start: number, end: number) =>
      Array.from({ length: end - start + 1 }, (v, k) => k + start);

    return range(1, this.MAX_NUMBER).map(i => FizzBuzz.generate(i, type));
  }

  private static _generate(num: number): string {
    const isFizz: boolean = num % 3 === 0;
    const isBuzz: boolean = num % 5 === 0;

    if (isFizz && isBuzz) {
      return this.FIZZ_BUZZ;
    }
    if (isFizz) {
      return this.FIZZ;
    }
    if (isBuzz) {
      return this.BUZZ;
    }

    return num.toString();
  }

  private _list: string[];
  get list() {
    return this._list;
  }

  set list(list: string[]) {
    this._list = list;
  }
}
