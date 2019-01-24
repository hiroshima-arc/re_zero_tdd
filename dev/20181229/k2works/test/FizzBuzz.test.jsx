/* eslint-env jest */
import React from "react";
import {shallow} from "enzyme";
import renderer from "react-test-renderer";
import {FizzBuzz} from "../src/components/FizzBuzz";
import {FizzBuzzMenu} from "../src/components/FizzBuzzMenu";
import {FizzBuzzCall} from "../src/components/FizzBuzzCall";

describe("FizzBuzzコンポーネント", () => {
  test("コンポーネントが存在すること", () => {
    const tree = renderer.create(
      <FizzBuzz/>
    ).toJSON();

    expect(tree).toMatchSnapshot();
  });

  test("FizzBuzzCallメニューを選択する", () => {
    const component = shallow(<FizzBuzzMenu/>);
    component
      .find("#nav-component__sub-menu--fizz-buzz-call")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzPrintメニューを選択する", () => {
    const component = shallow(<FizzBuzzMenu/>);
    component
      .find("#nav-component__sub-menu--fizz-buzz-print")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzUpDownメニューを選択する", () => {
    const component = shallow(<FizzBuzzMenu/>);
    component
      .find("#nav-component__sub-menu--fizz-buzz-up-down")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzIterateメニューを選択する", () => {
    const component = shallow(<FizzBuzzMenu/>);
    component
      .find("#nav-component__sub-menu--fizz-buzz-iterate")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzCallを実行する", () => {
    const component = shallow(<FizzBuzzCall/>);
    component
      .find("#fizz-buzz-component__button--call")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzPrintを実行する", () => {
    const component = shallow(<FizzBuzz/>);
    component
      .find("#fizz-buzz-component__button--print")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzUpを実行する", () => {
    const component = shallow(<FizzBuzz/>);
    component
      .find("#fizz-buzz-component__button--up")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzDownを実行する", () => {
    const component = shallow(<FizzBuzz/>);
    component
      .find("#fizz-buzz-component__button--down")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });

  test("FizzBuzzIterateを実行する", () => {
    const component = shallow(<FizzBuzz/>);

    component
      .find("#fizz-buzz-component__button--iterate")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });
});