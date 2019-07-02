package rental.domain.generics;

/**
* 加算可能
* @param <T>
*/
public interface Accumulate<T> {
  T add(T other);
}
