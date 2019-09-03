import { FizzBuzz } from "./FizzBuzz";

test("1から100までをプリントする", () => {
  const list: any[] = FizzBuzz.print1To100();
  expect(list[0]).toBe(1);
  expect(list[99]).toBe(100);
});
