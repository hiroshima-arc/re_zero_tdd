/* eslint-env jest */
import React from "react";
import {shallow, mount, render} from "enzyme";
import {FizzBuzz} from "../src/components/FizzBuzz";

test("コンポーネントが存在すること", () => {
  const wrapper = shallow(<FizzBuzz/>);
  expect(wrapper.length).toBe(1);
});