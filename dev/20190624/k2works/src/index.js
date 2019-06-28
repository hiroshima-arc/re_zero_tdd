import { statement, htmlStatement } from "./statement";
import { invoices, plays } from "./createStatementData";

const textStatement = statement(invoices[0], plays);
console.log(textStatement);
document.querySelector("#app").innerHTML = `<pre>${htmlStatement(
  invoices[0],
  plays
)}</pre>`;
