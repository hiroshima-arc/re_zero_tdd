/* eslint-env mocha */
// eslint-disable-next-line no-undef
const assert = chai.assert;
suite("FizzBuzzTest", () => {
  test("1から100までの数をプリントする,ただし3で割り切れる場合はFizz,5で割り切れる場合はBuzz,両方で割り切れる場合はFizzBuzzをプリントする", () => {
    const list = FizzBuzz.generate_list();
    assert.equal(1, list[0]);
    assert.equal("Fizz", list[2]);
    assert.equal("Buzz", list[4]);
    assert.equal("FizzBuzz", list[14]);
    assert.equal("Buzz", list[99]);
  });

  test("3で割り切れる場合はFizzを返す", () => {
    assert.equal("Fizz", FizzBuzz.exec(3));
  });

  test("5で割り切れる場合はBuzzを返す", () => {
    assert.equal("Buzz", FizzBuzz.exec(5));
  });

  test("3と5で割り切れる場合はFizzBuzzを返す", () => {
    assert.equal("FizzBuzz", FizzBuzz.exec(15));
  });
});

const FizzBuzz = {
  print() {
    this._renderTable(this.generate_list());
  },
  generate_list() {
    return [...Array(101).keys()].map(this.exec.bind(this)).slice(1);
  },
  exec(number) {
    if ((this._isFizz(number)) && (this._isBuzz(number))) return "FizzBuzz";
    if (this._isFizz(number)) return "Fizz";
    if (this._isBuzz(number)) return "Buzz";
    return number;
  },
  _renderTable: function(list) {
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
  },
  _isFizz(number) {
    return number % 3 === 0;
  },
  _isBuzz(number) {
    return number % 5 === 0;
  }
};