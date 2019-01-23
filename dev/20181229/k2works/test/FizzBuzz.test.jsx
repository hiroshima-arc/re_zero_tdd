/* eslint-env jest */
import React from "react";
import {shallow, mount, render} from "enzyme";
import {FizzBuzz} from "../src/components/FizzBuzz";

describe("FizzBuzzコンポーネント", () => {
  test("コンポーネントが存在すること", () => {
    const component = shallow(<FizzBuzz/>);
    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzCallメニューを選択する", () => {
    const component = mount(<FizzBuzz/>);
    component
      .find("#nav-component__sub-menu--fizz-buzz-call")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });

  test("FizzBuzzPrintメニューを選択する", () => {
    const component = mount(<FizzBuzz/>);
    component
      .find("#nav-component__sub-menu--fizz-buzz-print")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });

  test("FizzBuzzUpDownメニューを選択する", () => {
    const component = mount(<FizzBuzz/>);
    component
      .find("#nav-component__sub-menu--fizz-buzz-up-down")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });

  test("FizzBuzzIterateメニューを選択する", () => {
    const component = mount(<FizzBuzz/>);
    component
      .find("#nav-component__sub-menu--fizz-buzz-iterate")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });

  test("FizzBuzzCallを実行する", () => {
    const component = mount(<FizzBuzz/>);
    component
      .find("#fizz-buzz-component__button--call")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });

  test("FizzBuzzPrintを実行する", () => {
    const component = mount(<FizzBuzz/>);
    component
      .find("#fizz-buzz-component__button--print")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });

  test("FizzBuzzUpを実行する", () => {
    const component = mount(<FizzBuzz/>);
    component
      .find("#fizz-buzz-component__button--up")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });

  test("FizzBuzzDownを実行する", () => {
    const component = mount(<FizzBuzz/>);
    component
      .find("#fizz-buzz-component__button--down")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });

  test("FizzBuzzIterateを実行する", () => {
    const component = mount(<FizzBuzz/>);

    component
      .find("#fizz-buzz-component__button--iterate")
      .simulate("click");

    expect(component).toMatchSnapshot();
    component.unmount();
  });
});