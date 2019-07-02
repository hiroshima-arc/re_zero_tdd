package rental.presentation.view.statement;

import rental.domain.model.Rental;
import rental.domain.model.Rentals;
import java.time.LocalDate;

public class Statement {
  Rentals rentals;

  public Statement(Rentals rentals) {
    this.rentals = rentals;
  }

  public String statement() {
    return String.format("%s\n%s\n%s", header(), details(), footer());
  }

  private String header() {
    return String.format(
      "レンタル記録 %s様 %s\n",
      rentals.customer(),
      LocalDate.now()
    );
  }

  private String details() {
    StringBuilder result = new StringBuilder();
    for (Rental each : rentals.asList()) {
      result.append(
        String.format(
          "%s\t%s\t%s\t%s\n",
          each.movie(),
          each.days(),
          each.amount(),
          each.points()
        )
      );
    }
    return result.toString();
  }

  private String footer() {
    return String.format("%s\n%s", totalCharge(), totalPoints());
  }

  private String totalPoints() {
    return String.format("獲得ポイント %s", rentals.points());
  }

  private String totalCharge() {
    return String.format("合計金額 %s", rentals.charge());
  }
}
