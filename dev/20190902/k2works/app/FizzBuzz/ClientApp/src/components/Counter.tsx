import React, { Component } from "react";

// tslint:disable-next-line:no-empty-interface
interface IProps {}
interface IState {
  currentValue: string;
  currentCount: number;
}
export class Counter extends Component<IProps, IState> {
  public static displayName = Counter.name;

  constructor(props: IProps) {
    super(props);
    this.state = {
      currentValue: "Ready...",
      currentCount: 0
    };
    this.incrementCounter = this.incrementCounter.bind(this);
    this.generate = this.generate.bind(this);
  }

  public incrementCounter() {
    this.setState({
      currentCount: this.state.currentCount + 1
    });
  }

  public generate() {
    let number = this.state.currentCount;
    let url = `api/FizzBuzz/Generate/${number + 1}`;
    fetch(url)
      .then(response => response.json())
      .then(data => {
        this.setState({
          currentCount: this.state.currentCount + 1,
          currentValue: data.value
        });
      });
  }

  public render() {
    return (
      <div>
        <h1>FizzBuzzValue</h1>

        <p>This is a simple example of a React component.</p>

        <p>
          Current count: <strong>{this.state.currentCount}</strong>
        </p>
        <p>
          Current value: <strong>{this.state.currentValue}</strong>
        </p>

        <button className="btn btn-primary" onClick={this.generate}>
          Increment
        </button>
      </div>
    );
  }
}
