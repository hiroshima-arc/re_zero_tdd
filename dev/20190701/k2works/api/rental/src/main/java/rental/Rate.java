package rental;

public interface Rate {
  int amount(int daysRented);
  int point(int daysRented);
}
