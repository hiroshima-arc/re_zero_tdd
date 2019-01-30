export function renderHtmlTable(array) {
  let rowCount = 1;
  let html = "<table>";

  html = html + "<thead>";
  [...Array(10).keys()].forEach((v) => {
    html = html + `<th>${v + 1}</th>`;
  });
  html = html + "</thead>";

  html = html + "<tbody>";

  html = html + "<tr>";
  array.forEach((value) => {
    if (rowCount > 10) {
      html = html + "<tr>";
    }

    value = `<td>${value}</td>`;
    html = html + value;

    if (rowCount === 10) {
      html = html + "</tr>";
      rowCount = 1;
    } else {
      rowCount += 1;
    }
  });

  html = html + "</tbody>";
  html = html + "</table>";
  return html;
}