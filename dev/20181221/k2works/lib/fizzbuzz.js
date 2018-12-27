"use strict";

function _toConsumableArray(arr) {
  return _arrayWithoutHoles(arr) || _iterableToArray(arr) || _nonIterableSpread();
}

function _nonIterableSpread() {
  throw new TypeError("Invalid attempt to spread non-iterable instance");
}

function _iterableToArray(iter) {
  if (Symbol.iterator in Object(iter) || Object.prototype.toString.call(iter) === "[object Arguments]") return Array.from(iter);
}

function _arrayWithoutHoles(arr) {
  if (Array.isArray(arr)) {
    for (var i = 0, arr2 = new Array(arr.length); i < arr.length; i++) {
      arr2[i] = arr[i];
    }
    return arr2;
  }
}

// FizzBuzz
// Controller
[{
  "nav-component__sub-menu--call": showFizzBuzzCall
}, {
  "nav-component__sub-menu--print": showFizzBuzzPrint
}, {
  "nav-component__sub-menu--up-down": showFizzBuzzUpDown
}, {
  "nav-component__sub-menu--iterate": showFizzBuzzIterate
}, {
  "fizz-buzz-component__button--call": fizzBuzzCall
}, {
  "fizz-buzz-component__button--print": fizzBuzzPrint
}, {
  "fizz-buzz-component__button--down": fizzBuzzDown
}, {
  "fizz-buzz-component__button--up": fizzBuzzUp
}, {
  "fizz-buzz-component__button--iterate": fizzBuzzIterate
}].forEach(function (hash) {
  Object.keys(hash).forEach(function (key) {
    var menu = $("#".concat(key));
    menu.on("click", hash[key]);
  });
});

function showFizzBuzzCall() {
  showFizzBuzz({
    "call": "block",
    "print": "none",
    "updown": "none",
    "iterate": "none"
  });
}

function showFizzBuzzPrint() {
  showFizzBuzz({
    "call": "none",
    "print": "block",
    "updown": "none",
    "iterate": "none"
  });
}

function showFizzBuzzUpDown() {
  showFizzBuzz({
    "call": "none",
    "print": "none",
    "updown": "block",
    "iterate": "none"
  });
}

function showFizzBuzzIterate() {
  showFizzBuzz({
    "call": "none",
    "print": "none",
    "updown": "none",
    "iterate": "block"
  });
}

function showFizzBuzz() {
  var state = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {
    "call": "none",
    "print": "none",
    "updown": "none",
    "iterate": "none"
  };
  $("#fizz-buzz-component__article--call").css("display", state["call"]);
  $("#fizz-buzz-component__article--print").css("display", state["print"]);
  $("#fizz-buzz-component__article--up-down").css("display", state["updown"]);
  $("#fizz-buzz-component__article--iterate").css("display", state["iterate"]);
}

function renderHtmlTable(array) {
  var rowCount = 1;
  var html = "<table>";
  html = html + "<thead>";

  _toConsumableArray(Array(10).keys()).forEach(function (v) {
    html = html + "<th>".concat(v + 1, "</th>");
  });

  html = html + "</thead>";
  html = html + "<tbody>";
  html = html + "<tr>";
  array.forEach(function (value) {
    if (rowCount > 10) {
      html = html + "<tr>";
    }

    value = "<td>".concat(value, "</td>");
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
  var target = $("#fizz-buzz-component__iterate--result");
  var count = $("#fizz-buzz-component__input--iterate").val();

  if (count > COUNT) {
    return target.html("<strong>\u4EF6\u6570\u306F".concat(COUNT, "\u307E\u3067\u3067\u3059\u3002</strong>"));
  }

  var array = iterate(count);
  target.html(renderHtmlTable(array));
}

var fizzBuzzUpDownCount = 0;

function fizzBuzzUp() {
  fizzBuzzUpDownCount += 1;
  var target = $("#fizz-buzz-component__up-down--message");
  var count = fizzBuzzUpDownCount;
  var value = fizzBuzz(count);
  target.html(value);
}

function fizzBuzzDown() {
  if (fizzBuzzUpDownCount === 0) {
    fizzBuzzUpDownCount = 0;
  } else {
    fizzBuzzUpDownCount -= 1;
  }

  var target = $("#fizz-buzz-component__up-down--message");
  var count = fizzBuzzUpDownCount;
  target.html(fizzBuzz(count));
}

function fizzBuzzPrint() {
  var value = $("#fizz-buzz-component__input--print").val();
  var target = $("#fizz-buzz-component__print--message");

  if (isNaN(value)) {
    target.html("数字を入れてください。");
  } else {
    target.html(fizzBuzz(value));
  }
}

function fizzBuzzCall() {
  var value = $("#fizz-buzz-component__input--call").val();

  if (isNaN(value)) {
    alert("数字を入れてください。");
  } else {
    alert(fizzBuzz(value));
  }
}

var COUNT = 100;

function iterate(count) {
  var number = 1;
  var array = [];

  while (number <= count) {
    array.push(fizzBuzz(number));
    number++;
  }

  return array;
}

function execute() {
  iterate(COUNT).forEach(function (value) {
    console.log(value);
  });
} // Domain


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
} // exec program


execute();