package rental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rental.domain.model.Days;
import rental.domain.model.Rental;
import rental.domain.model.Rentals;
import rental.domain.model.customer.Customer;
import rental.domain.model.movie.Movie;
import rental.domain.model.movie.ReleaseDate;
import rental.presentation.view.statement.Statement;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementOutput {
  Movie newOne;
  Movie children;
  Movie regular;

  @BeforeEach
  void setupData() {
    ReleaseDate tenDaysBefore = new ReleaseDate(LocalDate.now().minusDays(10));
    ReleaseDate tenMonthsBefore = new ReleaseDate(
      LocalDate.now().minusMonths(10)
    );
    ReleaseDate fiveMonthBefore = new ReleaseDate(
      LocalDate.now().minusMonths(5)
    );

    newOne = Movie.children("新作", tenDaysBefore);
    children = Movie.children("子供", tenMonthsBefore);
    regular = Movie.create("一般", fiveMonthBefore);
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
        "獲得ポイント 4ポイント";
  }

  @Test
  @DisplayName("ステートメント出力")
  void output() {
    Customer customer = new Customer("山田");
    Rentals rentals = new Rentals(customer);
    rentals.addRental(new Rental(newOne, Days.of(3)));
    rentals.addRental(new Rental(children, Days.of(2)));
    rentals.addRental(new Rental(regular, Days.of(1)));
    Statement statement = new Statement(rentals);

    assertEquals(output, statement.statement());
  }
}
