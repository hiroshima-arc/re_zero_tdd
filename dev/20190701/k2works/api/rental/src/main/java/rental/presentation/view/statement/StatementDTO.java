package rental.presentation.view.statement;

import rental.domain.model.Rental;
import rental.domain.model.Rentals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatementDTO {
  Rentals rentals;
  Map<String, String> header;
  List<Map<String, String>> details;
  Map<String, String> footer;

  public Map<String, String> getHeader() {
    return header;
  }

  public List<Map<String, String>> getDetails() {
    return details;
  }

  public Map<String, String> getFooter() {
    return footer;
  }

  public StatementDTO(Rentals rentals) {
    this.rentals = rentals;
    this.header = new HashMap<>();
    this.header.put("title", header());

    this.details = new ArrayList<>();
    for (Rental each : rentals.asList()) {
      addDetails(each);
    }

    this.footer = new HashMap<>();
    this.footer.put("totalCharge", totalCharge());
    this.footer.put("totalPoints", totalPoints());
  }

  private void addDetails(Rental each) {
    Map<String, String> item = new HashMap<>();
    item.put("movie", each.movie().toString());
    item.put("days", each.days().toString());
    item.put("amount", each.amount().toString());
    item.put("point", each.points().toString());
    this.details.add(item);
  }

  private String header() {
    return String.format(
      "レンタル記録 %s様 %s",
      rentals.customer(),
      LocalDate.now()
    );
  }

  private String totalPoints() {
    return String.format("獲得ポイント %s", rentals.points());
  }

  private String totalCharge() {
    return String.format("合計金額 %s", rentals.charge());
  }
}
