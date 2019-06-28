import createStaementData from "./createStatementData";

export const plays = {
  hamlet: { name: "Hamlet", type: "tragedy" },
  "as-like": { name: "As You Like It", type: "comedy" },
  othello: { name: "Othello", type: "tragedy" }
};
export const invoices = [
  {
    customer: "BigCo",
    performances: [
      {
        playID: "hamlet",
        audience: 55
      },
      {
        playID: "as-like",
        audience: 35
      },
      {
        playID: "othello",
        audience: 40
      }
    ]
  }
];

export function statement(invoice, plays) {
  return renderPlainText(createStaementData(invoice, plays));
}

function renderPlainText(data, invoice, plays) {
  let result = `Statement for ${data.customer}\n`;
  for (let perf of data.performances) {
    // print line for this order
    result += ` ${perf.play.name}: ${usd(perf.amount)}(${
      perf.audience
    } seats)\n`;
  }
  result += `Amount owed is ${usd(data.totalAmount)}\n`;
  result += `You earned ${data.totalVolumeCredits} credits\n`;
  return result;

  function usd(aNumber) {
    return new Intl.NumberFormat("en-US", {
      style: "currency",
      currency: "USD",
      minimumFractionDigits: 2
    }).format(aNumber / 100);
  }
}
