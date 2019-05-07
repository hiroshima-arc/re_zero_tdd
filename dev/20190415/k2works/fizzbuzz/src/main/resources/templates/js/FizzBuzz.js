function showFizzBuzz() {
  let fizzBuzz = fizzBuzzFactory("one");
  fizzBuzz.render();
  document.querySelector("#app").style.display="block";
  document.querySelector("#app-api").style.display="none";
  document.querySelector("#mocha").style.display="none";
  document.querySelector("#message").innerHTML = "";
}

function getApiUrl() {
  let url = document.querySelector("#api-url").innerHTML;
  if (url === "") url = "http://localhost:8080/api";
  return url;
}

function showFizzBuzzApi() {
  const url = getApiUrl();
  renderFizzBuzzApiSelectBox();
  apiCall(`${url}/fizzbuzz/one`, 'POST', renderFizzBuzzApi);
  document.querySelector("#app").style.display="none";
  document.querySelector("#app-api").style.display="block";
  document.querySelector("#mocha").style.display="none";
}

function renderFizzBuzzApiSelectBox() {
  let selectBox = `
        <select name=”type” onchange="changeTypeByApiCall(event)">
            <option value="one">タイプ1</option>
            <option value="two">タイプ2</option>
            <option value="three">タイプ3</option>
        </select>
      `;

  const appApi = document.getElementById("app-api");
  const appApiSelectBox = appApi.getElementsByClassName("selectBox");
  appApiSelectBox[0].innerHTML = selectBox;
}

function renderFizzBuzzApi(values) {
  const header = () => {
    let header = "<thead>";
    header += "<tr>";
    [...Array(10).keys()].forEach((i) => header += `<th>${i + 1}</th>`);
    header += "</tr>";
    header += "</thead>";
    return header;
  };

  const items = () => {
    let count = 1;
    let result = "<tr>";
    values.forEach((value) => {
      result += `<td>${value.value}</td>`;
      if (count === 10) {
        result += "</tr>";
        result += "<tr>";
        count = 1;
      } else {
        count++;
      }
    });

    return result;
  };

  let table = `
            <table>
                ${header()}
                <tbody>
                ${items(values)}
                </tbody>
            </table>
    `;

  const appApi = document.getElementById("app-api");
  const appApiTable = appApi.getElementsByClassName("table");
  appApiTable[0].innerHTML = table;
}

function changeTypeByApiCall(e) {
  const typeValue = e.target.value;
  const url = getApiUrl();
  const clearTable = () => {
    document.querySelector("#app-api").style.display="none";
  };

  apiCall(`${url}/fizzbuzz/${typeValue}`, 'POST', renderFizzBuzzApi, clearTable);
}

function changeType(e) {
  let typeValue = e.target.value;
  let fizzBuzz = fizzBuzzFactory(typeValue);
  document.querySelector(".table").innerHTML = fizzBuzz.renderTable();
}

function fizzBuzzFactory(type) {
  const keys = Object.keys(Type);
  switch (type) {
    case keys[0]:
      return new FizzBuzz(Type.one);
    case keys[1]:
      return new FizzBuzz(Type.two);
    case keys[2]:
      return new FizzBuzz(Type.three);
    default:
      return new FizzBuzz(type1);
  }
}

const Type = {
  one: type1,
  two: type2,
  three: type3
};

function type1(number) {
  if (number % 3 === 0 && number % 5 === 0) return "FizzBuzz";
  if (number % 3 === 0) return "Fizz";
  if (number % 5 === 0) return "Buzz";
  return number;
}

function type2(number) {
  return number;
}

function type3() {
  return "FizzBuzz";
}

function FizzBuzz(type) {
  this.type = type;

  this.generate = (number) => {
    return this.type(number);
  };

  this.generateList = () => {
    return [...Array(101).keys()].map((i) => this.generate.call(this, i)).slice(1);
  };

  this.renderTable = () => {
    let table = `
            <table>
                <thead>
      `;
    table += `<tr>`;
    [...Array(10).keys()].forEach((i) => table += `<th>${i + 1}</th>`);
    table += `</tr>`;
    table += `
                </thead>
                <tbody>
      `;

    table = (() => {
      let counter = 0;
      return {
        create(list) {
          table += `<tr>`;
          list.forEach((item) => {
            table += `<td>${item}</td>`;
            counter++;
            if (counter === 10) {
              table += `</tr>`;
              table += `<tr>`;
              counter = 0;
            }
          });
          return table;
        }
      };
    })().create(this.generateList());

    table += `
                </tbody>
            </table>
      `;
    return table;
  };

  this.renderSelectBox = () => {
    return `
        <select name=”type” onchange="changeType(event)">
            <option value="one">タイプ1</option>
            <option value="two">タイプ2</option>
            <option value="three">タイプ3</option>
        </select>
      `;
  };

  this.render = () => {
    document.querySelector(".selectBox").innerHTML = this.renderSelectBox();
    document.querySelector(".table").innerHTML = this.renderTable();
  };
}
