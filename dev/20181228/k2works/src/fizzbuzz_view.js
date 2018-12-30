/**
 * @param array n x 10の二次元配列
 */
export function htmlTable(array) {
  const serial = [...Array(10).keys()].map(n => n+1);
  return `<table>
    <thead> 
      ${serial.map(th).join("")}
    </thead>
    <tbody>
      ${array.map(row => tr(row.map(td).join(""))).join("")}
    </tbody>
  </table>`;
}

/*
 * helper
 */

function tag (name, children) {
  return `<${name}>${children}</${name}>`;
}

function th (children) {
  return tag("th", children);
}

function tr (children) {
  return tag("tr", children);
}

function td(children) {
  return tag("td", children);
}
