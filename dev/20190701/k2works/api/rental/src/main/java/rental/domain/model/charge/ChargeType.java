package rental.domain.model.charge;

import rental.domain.model.DaysRented;

public enum ChargeType {
  NEW_RELEASE(0, 0, 300), REGULAR(200, 2, 150), CHILDREN(150, 3, 150);
  int baseCharge = 0;
  int baseDays = 0;
  int chargePerDay;

  private ChargeType(int baseAmount, int baseDays, int chargePerDay) {
    this.baseCharge = baseAmount;
    this.baseDays = baseDays;
    this.chargePerDay = chargePerDay;
  }

  public Charge amount(DaysRented daysRented) {
    Charge base = new Charge(baseCharge);
    return base.add(additionalAmount(daysRented));
  }

  private Charge additionalAmount(DaysRented daysRented) {
    if (daysRented.within(baseDays)) return new Charge(0);

    ChargePerDay perDay = new ChargePerDay(chargePerDay);
    DaysRented additionalDays = daysRented.minus(baseDays);
    return perDay.forDays(additionalDays);
  }
}
