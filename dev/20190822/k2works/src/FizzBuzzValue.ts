export class FizzBuzzValue {
  // tslint:disable-next-line: variable-name
  private _number: number;
  // tslint:disable-next-line: variable-name
  private _value: string;

  // tslint:disable-next-line: variable-name
  constructor(number: number, value: string) {
    this._number = number;
    this._value = value;
  }

  public get number(): number {
    return this._number;
  }

  public get value(): string {
    return this._value;
  }
}
