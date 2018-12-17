function assert(expected, actual) {
  console.log(".");
  console.assert(
    expected === actual,
    `\nexp:` + expected + `\nact:` + actual
  );
}

// Test
function test1から100までプリントする() {
  const array = iterate(100);
  assert(1, array[0]);
  assert("Buzz", array[99]);
}

function test3で割り切れる場合はFizzを返す() {
  assert("Fizz", fizzBuzz(3));
  assert(1, fizzBuzz(1));
}

function test5で割り切れる場合はBuzzを返す() {
  assert("Buzz", fizzBuzz(5));
}

function test3または5で割り切れる場合はFizzBuzzを返す() {
  assert("FizzBuzz", fizzBuzz(15));
}

// exec test
test1から100までプリントする();
test3で割り切れる場合はFizzを返す();
test5で割り切れる場合はBuzzを返す();
test3または5で割り切れる場合はFizzBuzzを返す();
