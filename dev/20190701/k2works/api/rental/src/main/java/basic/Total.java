package basic;

public class Total<T extends Accumulate<T>> {
  T value;

  public void cumulate(T other) {
    value = value.add(other);
  }

  public T result() {
    return value;
  }
}
