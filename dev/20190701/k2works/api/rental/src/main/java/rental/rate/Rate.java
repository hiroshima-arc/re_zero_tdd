package rental.rate;

public interface Rate {
  int amount(DaysRented daysRented);
  int point(DaysRented daysRented);
}
