import { FizzBuzzType } from "../../Domain/Type/FizzBuzzType";
import { FizzBuzzListCommand } from "../Command/FizzBuzzListCommand";
import { FizzBuzzValueCommand } from "../Command/FizzBuzzValueCommand";
import { IFizzBuzz } from "./IFizzBuzz";
import { IFizzBuzzCommand } from "./IFizzBuzzCommand";

export class FizzBuzzService {
  public generateList(type: string, input: number): IFizzBuzz {
    const command: IFizzBuzzCommand = new FizzBuzzListCommand(
      FizzBuzzType.valueOf(type)
    );
    return command.execute(input);
  }

  public generate(type: string, input: number): IFizzBuzz {
    const command: IFizzBuzzCommand = new FizzBuzzValueCommand(
      FizzBuzzType.valueOf(type)
    );
    return command.execute(input);
  }
}
