import { FizzBuzzService } from "../../Application/Service/FizzBuzzService";

export class FizzBuzzController {
  public readonly MAX_NUMBER = 100;
  public getModels(type: string) {
    return new FizzBuzzService().generateList(type, this.MAX_NUMBER);
  }
}
