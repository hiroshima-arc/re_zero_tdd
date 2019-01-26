/* eslint-env jest */
import React from "react";
import {shallow} from "enzyme";
import renderer from "react-test-renderer";
import {FizzBuzz} from "../src/components/FizzBuzz";
import {FizzBuzzMenu} from "../src/components/FizzBuzzMenu";
import {FizzBuzzCall} from "../src/components/FizzBuzzCall";
import {FizzBuzzPrint} from "../src/components/FizzBuzzPrint";
import {FizzBuzzUpDown} from "../src/components/FizzBuzzUpDown";
import {FizzBuzzIterate} from "../src/components/FizzBuzzIterate";

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

  describe("FizzBuzzCallコンポーネント", () => {
    test("コンポーネントが存在すること", () => {
      const component = shallow(<FizzBuzzCall/>);
      component
        .find("#fizz-buzz-component__button--call")
        .simulate("click");

      expect(component).toMatchSnapshot();
    });

    test("3を入力したらFizzを表示する", () => {
      window.alert = jest.fn();
      const component = shallow(<FizzBuzzCall/>);
      component.find("#fizz-buzz-component__input--call").simulate("change", {
        target: {value: "3"}
      });
      component.find("#fizz-buzz-component__button--call").simulate("click");
      expect(window.alert).toHaveBeenCalledWith("Fizz");
    });
  });

  describe("FizzBuzzPrint", () => {
    test("コンポーネントが存在すること", () => {
      const component = shallow(<FizzBuzzPrint/>);
      component
        .find("#fizz-buzz-component__button--print")
        .simulate("click");

      expect(component).toMatchSnapshot();
    });

    test("15を入力したらFizzBuzzを表示する", () => {
      const component = shallow(<FizzBuzzPrint/>);
      component.find("#fizz-buzz-component__input--print").simulate("change", {
        target: {value: "15"}
      });
      component.find("#fizz-buzz-component__button--print").simulate("click");
      expect(component.find("#fizz-buzz-component__print--message").text()).toEqual("FizzBuzz");
    });
  });

  describe("FizzBuzzUpDown", () => {
    test("FizzBuzzUpコンポーネントが存在する", () => {
      const component = shallow(<FizzBuzzUpDown/>);
      component
        .find("#fizz-buzz-component__button--up")
        .simulate("click");

      expect(component).toMatchSnapshot();
    });

    test("FizzBuzzDownコンポーネントが存在する", () => {
      const component = shallow(<FizzBuzzUpDown/>);
      component
        .find("#fizz-buzz-component__button--down")
        .simulate("click");

      expect(component).toMatchSnapshot();
    });
  });

  test("FizzBuzzIterateを実行する", () => {
    const component = shallow(<FizzBuzzIterate/>);

    component
      .find("#fizz-buzz-component__button--iterate")
      .simulate("click");

    expect(component).toMatchSnapshot();
  });
});