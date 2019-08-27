import { FizzBuzz } from "./FizzBuzz";

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
            </thead>
`;
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
            </tbody>
`;
})();

const table = `
          <table>
          ${header}
          ${body}
          </table>
`;

export function renderTable(): void {
  document.querySelector("#app").innerHTML = table;
}

renderTable();
