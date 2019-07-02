package rental.domain.model.movie;

public class Movie {
  String title;

  public String getTitle() {
    return title;
  }

  public ReleaseDate getReleaseDate() {
    return releaseDate;
  }

  public CategoryType getType() {
    return type;
  }

  ReleaseDate releaseDate;
  CategoryType type;

  public Movie(String title, ReleaseDate releaseDate, CategoryType type) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.type = type;
  }

  public static Movie children(String title, ReleaseDate releaseDate) {
    return new Movie(title, releaseDate, CategoryType.Children);
  }

  public static Movie create(String title, ReleaseDate releaseDate) {
    return new Movie(title, releaseDate, CategoryType.General);
  }

  public boolean forChildre() {
    return type == CategoryType.Children;
  }

  public boolean isNewRelease() {
    return releaseDate.isNewRelease();
  }

  @Override
  public String toString() {
    return title;
  }
}
