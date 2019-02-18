const assert = chai.assert;
suite("FizzBuzzTest", () => {
  test("greeting", () => {
    assert.equal("Hello, World!", FizzBuzz.greeting());
  });
});

const FizzBuzz = {
  greeting: function() {
    return "Hello, World!";
  },

  print() {
    const app = document.querySelector("#app");
    app.innerHTML = this.greeting();
  }
};