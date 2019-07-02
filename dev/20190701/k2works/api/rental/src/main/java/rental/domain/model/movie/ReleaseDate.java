package rental.domain.model.movie;

import java.time.LocalDate;

public class ReleaseDate {
  LocalDate releaseDate;

  public ReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public boolean isNewRelease() {
    LocalDate endOfNewRelease = releaseDate.plusMonths(2);
    return endOfNewRelease.isAfter(LocalDate.now());
  }
}
