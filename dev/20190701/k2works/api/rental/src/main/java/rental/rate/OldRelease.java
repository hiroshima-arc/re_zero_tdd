package rental.rate;

public class OldRelease implements Rate {
  MovieType movieType;

  public OldRelease(MovieType movieType) {
    this.movieType = movieType;
  }

  @Override
  public int amount(DaysRented daysRented) {
    return movieType.amount(daysRented.intValue());
  }

  @Override
  public int point(DaysRented daysRented) {
    return 1;
  }
}
