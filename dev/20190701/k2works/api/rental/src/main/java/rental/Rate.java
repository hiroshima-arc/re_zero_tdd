package rental;

public interface Rate {
  int amount(DaysRented daysRented);
  int point(DaysRented daysRented);
}
