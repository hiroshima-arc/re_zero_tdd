import React, { Component } from "react";

// tslint:disable-next-line:no-empty-interface
interface IProps {}
interface IState {
  forecasts: [];
  loading: boolean;
}
export class FetchData extends Component<IProps, IState> {
  public static displayName = FetchData.name;

  public static renderForecastsTable(forecasts: any) {
    return (
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Date</th>
            <th>Temp. (C)</th>
            <th>Temp. (F)</th>
            <th>Summary</th>
          </tr>
        </thead>
        <tbody>
          {forecasts.map((forecast: any) => (
            <tr key={forecast.dateFormatted}>
              <td>{forecast.dateFormatted}</td>
              <td>{forecast.temperatureC}</td>
              <td>{forecast.temperatureF}</td>
              <td>{forecast.summary}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }

  constructor(props: IProps) {
    super(props);
    this.state = { forecasts: [], loading: true };

    fetch("api/SampleData/WeatherForecasts")
      .then(response => response.json())
      .then(data => {
        this.setState({ forecasts: data, loading: false });
      });
  }

  public render() {
    const contents = this.state.loading ? (
      <p>
        <em>Loading...</em>
      </p>
    ) : (
      FetchData.renderForecastsTable(this.state.forecasts)
    );

    return (
      <div>
        <h1>Weather forecast</h1>
        <p>This component demonstrates fetching data from the server.</p>
        {contents}
      </div>
    );
  }
}
