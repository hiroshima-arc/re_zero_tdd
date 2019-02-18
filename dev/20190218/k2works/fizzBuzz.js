const assert = chai.assert;
suite("FizzBuzzTest", () => {
  test("1から100までの数をプリントする", () => {
    const list = FizzBuzz.print();
    assert.equal(1, list[0]);
  });
});

const FizzBuzz = {
  print() {
    let list = [];
    for (let i = 1; i <= 100; i++) {
      list.push(i);
    }

    let columnCount = 1;
    let html = "<table>";
    html += "<thead>";
    [...Array(10).keys()].forEach((key) => {
      html += `<th>${key + 1}</th>`;
    });
    html += "</thead>";
    html += "<tbody>";
    html += "<tr>";
    list.forEach((v) => {
      if (columnCount < 10) {
        html += `<td>${v}</td>`;
        columnCount += 1;
      } else {
        html += `<td>${v}</td>`;
        html += "</tr>";
        columnCount = 1;
      }
    });
    html += "</tbody>";
    html += "</table>";
    const app = document.querySelector("#app");
    app.innerHTML = html;

    return list;
  }
};