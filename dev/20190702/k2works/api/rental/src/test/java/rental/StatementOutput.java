package rental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rental.domain.Customer;
import rental.domain.Movie;
import rental.domain.Rental;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementOutput {
  Rental newRelease;
  Rental children;
  Rental regular;

  @BeforeEach
  void setupData() {
    Movie newReleaseMovie = new Movie("新作", Movie.NEW_RELEASE);
    Movie childrenMovie = new Movie("子供", Movie.CHILDREN);
    Movie regularMovie = new Movie("一般", Movie.REGULAR);

    newRelease = new Rental(newReleaseMovie, 3);
    children = new Rental(childrenMovie, 2);
    regular = new Rental(regularMovie, 1);
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
    customer.addRental(newRelease);
    customer.addRental(children);
    customer.addRental(regular);

    assertEquals(output, customer.statement());
  }
}
