import { IFizzBuzz } from "./IFizzBuzz";

export interface IFizzBuzzCommand {
  execute(input: number): IFizzBuzz;
}
