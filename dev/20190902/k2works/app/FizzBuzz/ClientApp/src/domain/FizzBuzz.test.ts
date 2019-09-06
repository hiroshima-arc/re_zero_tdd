import { FizzBuzz } from "./FizzBuzz";

describe("FizzBuzz", () => {
  test("1から100までをプリントする", () => {
    const list: string[] = FizzBuzz.generateList();
    expect(list[0]).toEqual("1");
    expect(list[2]).toEqual("Fizz");
    expect(list[4]).toEqual("Buzz");
    expect(list[14]).toEqual("FizzBuzz");
    expect(list[99]).toEqual("Buzz");
  });

  test("3で割り切れる場合はFizzをプリントする", () => {
    expect(FizzBuzz.generate(3)).toEqual("Fizz");
  });

  test("5で割り切れる場合はBuzzをプリントする", () => {
    expect(FizzBuzz.generate(5)).toEqual("Buzz");
  });

  test("15で割り切れる場合はFizzBuzzをプリントする", () => {
    expect(FizzBuzz.generate(15)).toEqual("FizzBuzz");
  });
});
