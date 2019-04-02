
package helloworld;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FizzBuzzTest {
  @Test
  public void test1から100までをプリントする() {
      assertEquals(1, FizzBuzz.print1To100());
  }
}
