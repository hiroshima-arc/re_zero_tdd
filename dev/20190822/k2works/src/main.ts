import { FizzBuzz } from "./FizzBuzz";

const fizzBuzzView = {
  create(): void {
    this._renderTable();
  },
  _renderTable(): void {
    const table = (() => {
      const range = (start: number, end: number) =>
        Array.from({ length: end - start + 1 }, (v, k) => k + start);

      const header: string = (() => {
        let element = "<tr>";
        range(1, 10).forEach(i => {
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
        FizzBuzz.generateList().forEach((v, k) => {
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
