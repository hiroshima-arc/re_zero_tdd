import { FizzBuzzListCommand } from "./Application/Command/FizzBuzzListCommand";
import { FizzBuzzValue } from "./Domain/Model/FizzBuzzValue";
import { FizzBuzzType } from "./Domain/Type/FizzBuzzType";
interface IHTMLElementEvent<T extends HTMLElement> extends Event {
  target: T;
}
const fizzBuzzView = {
  MAX_NUMBER: 100,
  create(): void {
    this.models = new FizzBuzzListCommand(FizzBuzzType.one).execute(
      this.MAX_NUMBER
    );
    this._renderType();
    this._renderTable();
  },
  _range: (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start),
  _renderType(): void {
    const select = (() => {
      return `
      <select id="type-select" name="type">
       <option value="one">タイプ1</option>
       <option value="two">タイプ2</option>
       <option value="three">タイプ3</option>
      </select>
      `;
    })();

    const changeType = (event: IHTMLElementEvent<HTMLInputElement>) => {
      this._rerenderTable(event.target.value);
    };

    document.querySelector("#app__select").innerHTML = select;
    document
      .querySelector("#type-select")
      .addEventListener("change", changeType);
  },
  _renderTable(): void {
    const table = (() => {
      const header: string = (() => {
        let element = "<tr>";
        this._range(1, 10).forEach(i => {
          element += `<th>${i}</th>`;
        });
        element += "</tr>";

        return `
            <thead>
            ${element}
            </thead>`;
      })();

      const body: string = (() => {
        let element = "<tr>";
        this.models.getList().forEach((v: FizzBuzzValue, k: number) => {
          element += `<td>${v.value}</td>`;
          if ((k + 1) % 10 === 0) {
            element += "</tr>";
          }
        });

        return `
            <tbody>
            ${element}
            </tbody>`;
      })();

      return `
          <table>
          ${header}
          ${body}
          </table>`;
    })();

    document.querySelector("#app__table").innerHTML = table;
  },
  _rerenderTable(type: string): void {
    switch (type) {
      case "one":
        this.models = new FizzBuzzListCommand(FizzBuzzType.one).execute(
          this.MAX_NUMBER
        );
        break;
      case "two":
        this.models = new FizzBuzzListCommand(FizzBuzzType.two).execute(
          this.MAX_NUMBER
        );
        break;
      case "three":
        this.models = new FizzBuzzListCommand(FizzBuzzType.three).execute(
          this.MAX_NUMBER
        );
        break;
      default:
        this.models = new FizzBuzzListCommand(FizzBuzzType.one).execute(
          this.MAX_NUMBER
        );
    }
    this._renderTable();
  }
};

fizzBuzzView.create();
