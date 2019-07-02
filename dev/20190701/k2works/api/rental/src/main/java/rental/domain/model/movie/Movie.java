package rental.domain.model.movie;

public class Movie {
  String title;

  ReleaseDate releaseDate;
  MovieType type;

  public Movie(String title, ReleaseDate releaseDate, MovieType type) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.type = type;
  }

  public static Movie children(String title, ReleaseDate releaseDate) {
    return new Movie(title, releaseDate, MovieType.Children);
  }

  public static Movie create(String title, ReleaseDate releaseDate) {
    return new Movie(title, releaseDate, MovieType.General);
  }

  public boolean forChildre() {
    return type == MovieType.Children;
  }

  public boolean isNewRelease() {
    return releaseDate.isNewRelease();
  }

  @Override
  public String toString() {
    return title;
  }
}
