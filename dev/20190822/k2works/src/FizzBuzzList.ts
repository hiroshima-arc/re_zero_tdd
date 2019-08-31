import { FizzBuzzValue } from "./FizzBuzzValue";
import { IFizzBuzz } from "./IFizzBuzz";

export class FizzBuzzList implements IFizzBuzz {
  public get list(): FizzBuzzValue[] {
    return this._list;
  }
  // tslint:disable-next-line: variable-name
  private _list: FizzBuzzValue[];

  constructor(list: FizzBuzzValue[]) {
    this._list = list;
  }

  public getValue(): string {
    return "";
  }

  public getList(): FizzBuzzValue[] {
    return this.list;
  }

  public add(value: FizzBuzzValue): FizzBuzzList {
    this._list.push(value);
    return new FizzBuzzList(this._list);
  }
}
