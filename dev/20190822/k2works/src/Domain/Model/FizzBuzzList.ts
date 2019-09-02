import { FizzBuzzValue } from "./FizzBuzzValue";
import { IFizzBuzz } from "./IFizzBuzz";

export class FizzBuzzList implements IFizzBuzz {
  public get list(): FizzBuzzValue[] {
    return this._list;
  }
  // tslint:disable-next-line: variable-name
  private _list: FizzBuzzValue[];

  constructor(list: FizzBuzzValue[]) {
    if (list.length > 100) {
      throw new Error("FizzBuzzList can't generate over 100");
    }
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
