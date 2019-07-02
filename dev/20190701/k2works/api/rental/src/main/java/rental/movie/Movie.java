package rental.movie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Movie {
  String title;

  LocalDate releaseDate;
  MovieType type;

  public Movie(String title, LocalDate releaseDate, MovieType type) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.type = type;
  }

  public long daysFromRelease() {
    return ChronoUnit.DAYS.between(releaseDate, LocalDate.now());
  }

  public boolean forChildre() {
    return type == MovieType.Children;
  }

  public String title() {
    return title;
  }
}
