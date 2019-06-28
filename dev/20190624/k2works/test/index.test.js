import { expect } from "chai";
import {statement, htmlStatement, invoices, plays} from '../src/statement';
describe("Volume Credits", ()=> {
  it("print text statement", () => {
    expect('Statement for BigCo\n Hamlet: $650.00(55 seats)\n As You Like It: $580.00(35 seats)\n Othello: $500.00(40 seats)\nAmount owed is $1,730.00\nYou earned 47 credits\n').to.equal(statement(invoices[0], plays))
  });
  it("print html statement", () => {
    expect('<h1>Statement for BigCo</h1>\n<table>\n<tr><th>play</th><th>seats</th><th>cost</th></tr> <tr><td>Hamlet</td><td>55</td> <td>$650.00</td></tr>\n <tr><td>As You Like It</td><td>35</td> <td>$580.00</td></tr>\n <tr><td>Othello</td><td>40</td> <td>$500.00</td></tr>\n</table>\n<p>Amount owed is <em>$1,730.00</em></p>\n<p>You earned <em>47</em>credits</p>\n').to.equal(htmlStatement(invoices[0], plays))
  })
});
