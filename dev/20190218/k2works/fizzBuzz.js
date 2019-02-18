const assert = chai.assert;
suite("FizzBuzzTest", () => {
  test("1から100までの数をプリントする", () => {
    const list = FizzBuzz.print();
    assert.equal(1, list[0]);
  });

  test("3で割り切れる場合はFizzを返す", () => {
    assert.equal("Fizz", FizzBuzz.exec(3));
  });

  test("5で割り切れる場合はBuzzを返す", () => {
    assert.equal("Buzz", FizzBuzz.exec(5));
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
  },
  exec(number) {
    let result = number;

    if (number % 3 === 0) {
      result = "Fizz";
    } else if (number % 5 === 0) {
      result = "Buzz";
    }

    return result;
  }
};