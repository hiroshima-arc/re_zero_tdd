import React, { Component } from "react";

// tslint:disable-next-line:no-empty-interface
interface IProps {}
interface IState {
  currentCount: number;
}
export class Counter extends Component<IProps, IState> {
  public static displayName = Counter.name;

  constructor(props: IProps) {
    super(props);
    this.state = { currentCount: 0 };
    this.incrementCounter = this.incrementCounter.bind(this);
  }

  public incrementCounter() {
    this.setState({
      currentCount: this.state.currentCount + 1
    });
  }

  public render() {
    return (
      <div>
        <h1>Counter</h1>

        <p>This is a simple example of a React component.</p>

        <p>
          Current count: <strong>{this.state.currentCount}</strong>
        </p>

        <button className="btn btn-primary" onClick={this.incrementCounter}>
          Increment
        </button>
      </div>
    );
  }
}
