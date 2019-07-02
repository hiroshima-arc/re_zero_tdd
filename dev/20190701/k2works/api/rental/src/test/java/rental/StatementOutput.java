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
      "レンタル記録 山田様 " +
        LocalDate.now() +
        "\n" +
        "\n" +
        "新作\t3日間\t900円\t2ポイント\n" +
        "子供\t2日間\t150円\t1ポイント\n" +
        "一般\t1日間\t200円\t1ポイント\n" +
        "\n" +
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
