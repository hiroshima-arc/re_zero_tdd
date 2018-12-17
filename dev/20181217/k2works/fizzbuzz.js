// FizzBuzz
// Controller
[
  { "nav-component__sub-menu--call": showFizzBuzzCall },
  { "nav-component__sub-menu--print": showFizzBuzzPrint },
  { "nav-component__sub-menu--up-down": showFizzBuzzUpDown },
  { "nav-component__sub-menu--iterate": showFizzBuzzIterate },
  { "fizz-buzz-component__button--call": fizzBuzzCall },
  { "fizz-buzz-component__button--print": fizzBuzzPrint },
  { "fizz-buzz-component__button--down": fizzBuzzDown },
  { "fizz-buzz-component__button--up": fizzBuzzUp },
  { "fizz-buzz-component__button--iterate": fizzBuzzIterate }
].forEach(hash => {
  Object.keys(hash).forEach(key => {
    let menu = $(`#${key}`);
    menu.on("click", hash[key]);
  });
});

function showFizzBuzzCall() {
  showFizzBuzz(
    {
      "call": "block",
      "print": "none",
      "updown": "none",
      "iterate": "none"
    }
  );
}

function showFizzBuzzPrint() {
  showFizzBuzz(
    {
      "call": "none",
      "print": "block",
      "updown": "none",
      "iterate": "none"
    }
  );
}

function showFizzBuzzUpDown() {
  showFizzBuzz(
    {
      "call": "none",
      "print": "none",
      "updown": "block",
      "iterate": "none"
    }
  );
}

function showFizzBuzzIterate() {
  showFizzBuzz(
    {
      "call": "none",
      "print": "none",
      "updown": "none",
      "iterate": "block"
    }
  );
}

function showFizzBuzz(
  state = {
    "call": "none",
    "print": "none",
    "updown": "none",
    "iterate": "none"
  }
) {
  $("#fizz-buzz-component__article--call").css("display", state["call"]);
  $("#fizz-buzz-component__article--print").css("display", state["print"]);
  $("#fizz-buzz-component__article--up-down").css("display", state["updown"]);
  $("#fizz-buzz-component__article--iterate").css("display", state["iterate"]);
}

function renderHtmlTable(array) {
  let rowCount = 1;
  let html = "<table>";

  html = html + "<thead>";
  [...Array(10).keys()].forEach(function(v) {
    html = html + `<th>${v + 1}</th>`;
  });
  html = html + "</thead>";

  html = html + "<tbody>";

  html = html + "<tr>";
  array.forEach(function(value) {
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

function fizzBuzzIterate() {
  const target = $("#fizz-buzz-component__iterate--result");
  let count = $("#fizz-buzz-component__input--iterate").val();
  if (count > COUNT) {
    return target.html(`<strong>件数は${COUNT}までです。</strong>`);
  }

  const array = iterate(count);

  target.html(renderHtmlTable(array));
}

fizzBuzzUpDownCount = 0;

function fizzBuzzUp() {
  fizzBuzzUpDownCount += 1;
  const target = $("#fizz-buzz-component__up-down--message");
  const count = fizzBuzzUpDownCount;
  const value = fizzBuzz(count);
  target.html(value);
}

function fizzBuzzDown() {
  if (fizzBuzzUpDownCount === 0) {
    fizzBuzzUpDownCount = 0;
  } else {
    fizzBuzzUpDownCount -= 1;
  }
  const target = $("#fizz-buzz-component__up-down--message");
  const count = fizzBuzzUpDownCount;
  target.html(fizzBuzz(count));
}

function fizzBuzzPrint() {
  const value = $("#fizz-buzz-component__input--print").val();
  const target = $("#fizz-buzz-component__print--message");
  if (isNaN(value)) {
    target.html("数字を入れてください。");
  } else {
    target.html(fizzBuzz(value));
  }
}

function fizzBuzzCall() {
  const value = $("#fizz-buzz-component__input--call").val();
  if (isNaN(value)) {
    alert("数字を入れてください。");
  } else {
    alert(fizzBuzz(value));
  }
}

const COUNT = 100;

function iterate(count) {
  let number = 1;
  let array = [];

  while (number <= count) {
    array.push(fizzBuzz(number));
    number++;
  }
  return array;
}

function execute() {
  iterate(COUNT).forEach(function(value) {
    console.log(value);
  });
}

// Domain
function fizzBuzz(number) {
  if (number % 3 === 0 && number % 5 === 0) {
    return "FizzBuzz";
  } else if (number % 3 === 0) {
    return "Fizz";
  } else if (number % 5 === 0) {
    return "Buzz";
  } else {
    return number;
  }
}

// exec program
execute();