import { invoices, plays, statement } from "./statement";
const textStatement = statement(invoices[0], plays);
console.log(textStatement);
document.querySelector("#app").innerHTML = `<pre>${textStatement}</pre>`;
