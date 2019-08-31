import { FizzBuzzValue } from "./FizzBuzzValue";

export class FizzBuzzList {
  // tslint:disable-next-line: variable-name
  private _list: FizzBuzzValue[];

  constructor(list: FizzBuzzValue[]) {
    this._list = list;
  }

  public get list(): FizzBuzzValue[] {
    return this._list;
  }

  public add(value: FizzBuzzValue): FizzBuzzList {
    this._list.push(value);
    return new FizzBuzzList(this._list);
  }
}
