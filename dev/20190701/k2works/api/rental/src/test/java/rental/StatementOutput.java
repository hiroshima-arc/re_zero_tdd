package rental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rental.customer.Customer;
import rental.movie.Movie;
import rental.movie.MovieType;
import rental.statement.Statement;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementOutput {
  Rental newRelease;
  Rental children;
  Rental regular;

  @BeforeEach
  void setupData() {
    Movie newReleaseMovie = new Movie(
      "新作",
      LocalDate.now().minusDays(10),
      MovieType.Children
    );
    Movie childrenMovie = new Movie(
      "子供",
      LocalDate.now().minusDays(30 * 10),
      MovieType.Children
    );
    Movie regularMovie = new Movie(
      "一般",
      LocalDate.now().minusDays(30 * 5),
      MovieType.General
    );

    newRelease = new Rental(newReleaseMovie, new DaysRented(3));
    children = new Rental(childrenMovie, new DaysRented(2));
    regular = new Rental(regularMovie, new DaysRented(1));
  }

  String output;

  @BeforeEach
  void setupResult() {
    output =
      "山田様のレンタル明細\n" +
        "\t新作\t900円\n" +
        "\t子供\t150円\n" +
        "\t一般\t200円\n" +
        "合計金額 1250円\n" +
        "獲得ポイント 4p";
  }

  @Test
  @DisplayName("ステートメント出力")
  void output() {
    Customer customer = new Customer("山田");
    Rentals rentals = new Rentals(customer);
    rentals.addRental(newRelease);
    rentals.addRental(children);
    rentals.addRental(regular);
    Statement statement = new Statement(rentals);

    assertEquals(output, statement.statement());
  }
}
