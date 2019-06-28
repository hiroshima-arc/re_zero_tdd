export default function createStaementData(invoice, plays) {
  const statementData = {};
  statementData.customer = invoice.customer;
  statementData.performances = invoice.performances.map(enrichPerformance);
  statementData.totalAmount = totalAmount(statementData);
  statementData.totalVolumeCredits = totalVolumeCredits(statementData);
  return statementData;

  function enrichPerformance(aPerformance) {
    const result = Object.assign({}, aPerformance);
    result.play = playFor(result);
    result.amount = amountFor(result);
    result.volumeCredits = volumeCreditsFor(result);
    return result;
  }
  function playFor(aPerformance) {
    return plays[aPerformance.playID];
  }
  function amountFor(aPerformances) {
    let result = 0;

    switch (aPerformances.play.type) {
      case "tragedy":
        result = 40000;
        if (aPerformances.audience > 30) {
          result += 1000 * (aPerformances.audience - 30);
        }
        break;
      case "comedy":
        result = 30000;
        if (aPerformances.audience > 20) {
          result += 10000 + 500 * (aPerformances.audience - 20);
        }
        result += 300 * aPerformances.audience;
        break;
      default:
        throw new Error(`unknown type: ${aPerformances.play.type}`);
    }
    return result;
  }
  function volumeCreditsFor(aPerformance) {
    let result = 0;
    result += Math.max(aPerformance.audience - 30, 0);
    if ("comedy" === aPerformance.play.type)
      result += Math.floor(aPerformance.audience / 5);
    return result;
  }
  function totalAmount(data) {
    return data.performances.reduce((total, p) => total + p.amount, 0);
  }
  function totalVolumeCredits(data) {
    return data.performances.reduce((total, p) => total + p.volumeCredits, 0);
  }
}
