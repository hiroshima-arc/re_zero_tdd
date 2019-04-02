
package helloworld;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FizzBuzzTest {
  @Test
  public void test1から100までをプリントする() {
      int[] list = FizzBuzz.print1To100();
      assertEquals(1, list[0]);
      assertEquals(100,list[1]);
  }
}
