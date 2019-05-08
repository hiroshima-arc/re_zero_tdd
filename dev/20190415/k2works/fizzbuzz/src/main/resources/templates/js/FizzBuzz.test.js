const assert = chai.assert;
mocha.setup("tdd");
suite("FizzBuzzTest", () => {
  test("値を1から100までプリントするただし、3で割り切れる場合はFizz5で割り切れる場合はBuzz両方で割り切れる場合はFizzBuzzをプリントする", () => {
    let fizzBuzz = new FizzBuzz(Type.one);
    let list = fizzBuzz.generateList();
    assert.equal(1, list[0]);
    assert.equal("Fizz", list[2]);
    assert.equal("Buzz", list[4]);
    assert.equal("FizzBuzz", list[14]);
    assert.equal("Buzz", list[99]);
  });

  suite("タイプ1の場合", () => {
    test("値が3で割り切れる場合はFizzをプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.one);
      assert.equal("Fizz", fizzBuzz.generate(3));
    });

    test("値が5で割り切れる場合はBuzzをプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.one);
      assert.equal("Buzz", fizzBuzz.generate(5));
    });

    test("値が3または5で割り切れる場合はFizzBuzzをプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.one);
      assert.equal("FizzBuzz", fizzBuzz.generate(15));
    });
  });

  suite("タイプ2の場合", () => {
    test("値が3で割り切れる場合は3をプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.two);
      assert.equal(3, fizzBuzz.generate(3));
    });

    test("値が5で割り切れる場合は5をプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.two);
      assert.equal(5, fizzBuzz.generate(5));
    });

    test("値が3または5で割り切れる場合は値をプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.two);
      assert.equal(15, fizzBuzz.generate(15));
    });
  });

  suite("タイプ3の場合", () => {
    test("値が3で割り切れる場合はFizzBuzzをプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.three);
      assert.equal("FizzBuzz", fizzBuzz.generate(3));
    });

    test("値が5で割り切れる場合はFizzBuzzをプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.three);
      assert.equal("FizzBuzz", fizzBuzz.generate(5));
    });

    test("値が3または5で割り切れる場合はFizzBuzzをプリントする", () => {
      let fizzBuzz = new FizzBuzz(Type.three);
      assert.equal("FizzBuzz", fizzBuzz.generate(15));
    });
  });
});
