import React, { Component } from "react";

// tslint:disable-next-line:no-empty-interface
interface IProps {}
interface IState {
  forecasts: [];
  loading: boolean;
  fizzBuzzList: [];
}
export class FetchData extends Component<IProps, IState> {
  public static displayName = FetchData.name;

  public static renderFizzBuzzListTable(fizzBuzzList: any) {
    const tbody = (() => {
      let table: any[] = [];
      let row: any[] = [];
      fizzBuzzList.forEach((item: any, key: number) => {
        row.push(item.value);
        if ((key + 1) % 10 === 0) {
          table.push(row);
          row = [];
        }
      });
      return table;
    })();

    return (
      <table className="table table-striped">
        <thead>
          <tr>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            <th>5</th>
            <th>6</th>
            <th>7</th>
            <th>8</th>
            <th>9</th>
            <th>10</th>
          </tr>
        </thead>
        <tbody>
          {tbody.map((row: any, key: number) => (
            <tr key={key}>
              <td>{row[0]}</td>
              <td>{row[1]}</td>
              <td>{row[2]}</td>
              <td>{row[3]}</td>
              <td>{row[4]}</td>
              <td>{row[5]}</td>
              <td>{row[6]}</td>
              <td>{row[7]}</td>
              <td>{row[8]}</td>
              <td>{row[9]}</td>
              <td>{row[10]}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }

  constructor(props: IProps) {
    super(props);
    this.state = { forecasts: [], fizzBuzzList: [], loading: true };
    const number = 100;
    let url = `api/FizzBuzz/GenerateList/${number}`;
    fetch(url)
      .then(response => response.json())
      .then(data => {
        this.setState({ forecasts: data, fizzBuzzList: data, loading: false });
      });
  }

  public render() {
    const contents = this.state.loading ? (
      <p>
        <em>Loading...</em>
      </p>
    ) : (
      FetchData.renderFizzBuzzListTable(this.state.fizzBuzzList)
    );

    return (
      <div>
        <h1>FizzBuzzList</h1>
        <p>This component demonstrates fetching data from the server.</p>
        {contents}
      </div>
    );
  }
}
