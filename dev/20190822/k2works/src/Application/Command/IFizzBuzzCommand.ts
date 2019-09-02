import { IFizzBuzz } from "../../Domain/Model/IFizzBuzz";

export interface IFizzBuzzCommand {
  execute(input: number): IFizzBuzz;
}
