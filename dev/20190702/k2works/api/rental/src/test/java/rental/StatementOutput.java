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

  String textOutput;
  String htmlOutput;

  @BeforeEach
  void setupResult() {
    textOutput =
      "山田様のレンタル明細\n" +
        "\t新作\t900円\n" +
        "\t子供\t150円\n" +
        "\t一般\t200円\n" +
        "合計金額 1250円\n" +
        "獲得ポイント 4ポイント";

    htmlOutput =
      "<H1><EM>山田</EM>様のレンタル明細</H1>\n" +
        "新作: 900円<BR>\n" +
        "子供: 150円<BR>\n" +
        "一般: 200円<BR>\n" +
        "<P>合計金額 <EM>1250円</EM></P>\n" +
        "<P>獲得ポイント <EM>4ポイント</EM></P>";
  }

  @Test
  @DisplayName("ステートメント出力")
  void textOutput() {
    Customer customer = new Customer("山田");
    customer.addRental(newRelease);
    customer.addRental(children);
    customer.addRental(regular);

    assertEquals(textOutput, customer.statement());
  }

  @Test
  @DisplayName("HTMLステートメント出力")
  void htmlOutput() {
    Customer customer = new Customer("山田");
    customer.addRental(newRelease);
    customer.addRental(children);
    customer.addRental(regular);

    assertEquals(htmlOutput, customer.htmlStatement());
  }
}
