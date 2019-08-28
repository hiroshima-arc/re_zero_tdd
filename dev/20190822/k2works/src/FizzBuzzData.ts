export class FizzBuzzData {
  private _list: string[];

  get list() {
    return this._list;
  }

  set list(list: string[]) {
    this._list = list;
  }
}
