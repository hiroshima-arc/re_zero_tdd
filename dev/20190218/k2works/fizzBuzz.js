/* eslint-env mocha */
// eslint-disable-next-line no-undef
const assert = chai.assert;
suite("FizzBuzzTest", () => {
  test("1から100までの数をプリントする,ただし3で割り切れる場合はFizz,5で割り切れる場合はBuzz,両方で割り切れる場合はFizzBuzzをプリントする", () => {
    const list = FizzBuzz.generateList();
    assert.equal(1, list[0]);
    assert.equal("Fizz", list[2]);
    assert.equal("Buzz", list[4]);
    assert.equal("FizzBuzz", list[14]);
    assert.equal("Buzz", list[99]);
  });

  test("3で割り切れる場合はFizzを返す", () => {
    assert.equal("Fizz", FizzBuzz.generate(3));
  });

  test("5で割り切れる場合はBuzzを返す", () => {
    assert.equal("Buzz", FizzBuzz.generate(5));
  });

  test("3と5で割り切れる場合はFizzBuzzを返す", () => {
    assert.equal("FizzBuzz", FizzBuzz.generate(15));
  });
});

const MAX_RANGE = 101;
const FIZZ_BUZZ = "FizzBuzz";
const FIZZ = "Fizz";
const BUZZ = "Buzz";
const FizzBuzz = {
  print() {
    this._renderTable(this.generateList());
  },
  generateList() {
    return [...Array(MAX_RANGE).keys()].map(this.generate.bind(this)).slice(1);
  },
  generate(number) {
    if ((this._isFizz(number)) && (this._isBuzz(number))) return FIZZ_BUZZ;
    if (this._isFizz(number)) return FIZZ;
    if (this._isBuzz(number)) return BUZZ;
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