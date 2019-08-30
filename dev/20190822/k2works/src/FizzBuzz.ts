import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzz {
  public get list(): string[] {
    return this._list;
  }
  public static readonly MAX_NUMBER: number = 100;
  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);

  // tslint:disable-next-line: variable-name
  private _list: string[];
  // tslint:disable-next-line: variable-name
  private _type: IFizzBuzzType;

  constructor(type: IFizzBuzzType) {
    this._type = type;
  }

  public generate(input: number) {
    return this._type.generate(input);
  }

  public generateList(): void {
    this._list = FizzBuzz.range(1, FizzBuzz.MAX_NUMBER).map(i =>
      this.generate(i)
    );
  }
}
