import { invoices, plays, statement, htmlStatement } from "./statement";
const textStatement = statement(invoices[0], plays);
console.log(textStatement);
document.querySelector("#app").innerHTML = `<pre>${htmlStatement(
  invoices[0],
  plays
)}</pre>`;
