export function htmlTable(array, number) {
  const header = [...Array(number).keys()].map(n => n + 1);
  return `<table>
            <thead>
              ${header.map(th).join("")}
            </thead>
            <tbody>
             ${array.map(row => tr(row.map(td).join(""))).join("")}
            </tbody>
          </table>`;
}

function tag(name, children) {
  return `<${name}>${children}</${name}>`;
}

function th(children) {
  return tag("th", children);
}

function tr(children) {
  return tag("tr", children);
}

function td(children) {
  return tag("td", children);
}