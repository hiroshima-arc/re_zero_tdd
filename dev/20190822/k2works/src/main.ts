import { throws } from "assert";
import { FizzBuzz } from "./FizzBuzz";
import { FizzBuzzType } from "./FizzBuzzType";

const fizzBuzzView = {
  create(): void {
    this.model = new FizzBuzz(FizzBuzzType.one);
    this.model.generateList();
    this._renderTable();
  },
  _range: (start: number, end: number) =>
    Array.from({ length: end - start + 1 }, (v, k) => k + start),
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
        this.model.list.forEach((v, k) => {
          element += `<td>${v}</td>`;
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

    document.querySelector("#app").innerHTML = table;
  }
};

fizzBuzzView.create();
