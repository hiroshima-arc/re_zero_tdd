package rental.domain.model.customer;

public class Customer {
  String name;

  public Customer(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }
}
