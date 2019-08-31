import { FizzBuzzList } from "./FizzBuzzList";
import { FizzBuzzValue } from "./FizzBuzzValue";
import { IFizzBuzzType } from "./IFizzBuzzType";

export class FizzBuzz {
  public get list(): FizzBuzzValue[] {
    return this._list.list;
  }
  public static readonly MAX_NUMBER: number = 100;
  public static readonly range = (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start);

  // tslint:disable-next-line: variable-name
  private _list: FizzBuzzList;
  // tslint:disable-next-line: variable-name
  private _type: IFizzBuzzType;

  constructor(type: IFizzBuzzType) {
    this._list = new FizzBuzzList([]);
    this._type = type;
  }

  public generate(input: number): FizzBuzzValue {
    return this._type.generate(input);
  }

  public generateList(): void {
    FizzBuzz.range(1, FizzBuzz.MAX_NUMBER).forEach(
      i => (this._list = this._list.add(this.generate(i)))
    );
  }
}
