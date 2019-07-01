package rental;

public class OldRelease implements Rate {
  MovieType movieType;

  OldRelease(MovieType movieType) {
    this.movieType = movieType;
  }

  @Override
  public int amount(int daysRented) {
    return movieType.amount(daysRented);
  }

  @Override
  public int point(int daysRented) {
    return 1;
  }
}
