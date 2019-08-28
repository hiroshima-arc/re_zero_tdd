export class FizzBuzzType02 {
  // tslint:disable-next-line: variable-name
  private _number: number;

  constructor(input: number) {
    this._number = input;
  }

  public generate(): string {
    return this._number.toString();
  }
}
