import { FizzBuzz } from "./FizzBuzz";

describe("FizzBuzz", () => {
  test("1から100までをプリントする", () => {
    const list: any[] = FizzBuzz.print1To100();
    expect(list[0]).toBe(1);
    expect(list[99]).toBe(100);
  });

  test("3で割り切れる場合はFizzをプリントする", () => {
    expect(FizzBuzz.generate(3)).toEqual("Fizz");
  });

  test("5で割り切れる場合はBuzzをプリントする", () => {
    expect(FizzBuzz.generate(5)).toEqual("Buzz");
  });
});
