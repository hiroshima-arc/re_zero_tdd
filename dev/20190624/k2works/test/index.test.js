import { expect } from "chai";
import {statement, invoices, plays} from '../src/statement';
describe("Volume Credits", ()=> {
  it("print text statement", () => {
    expect('Statement for BigCo\n Hamlet: $650.00(55 seats)\n As You Like It: $580.00(35 seats)\n Othello: $500.00(40 seats)\nAmount owed is $1,730.00\nYou earned 47 credits\n').to.equal(statement(invoices[0], plays))
  })
});
