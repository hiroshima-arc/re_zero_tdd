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

