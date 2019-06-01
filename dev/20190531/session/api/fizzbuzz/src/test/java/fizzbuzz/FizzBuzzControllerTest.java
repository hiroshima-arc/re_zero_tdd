package fizzbuzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzControllerTest {
  @Autowired
  private MockMvc mvc;

  @Test
  public void getFizzBuzz() throws Exception {
    ResultActions resultActions = mvc.perform(
      MockMvcRequestBuilders.get("/fizzbuzz").accept(MediaType.APPLICATION_JSON)
    ).andExpect(status().isOk()).andExpect(
      content().string(
        equalTo(
          "[{\"value\":\"1\",\"number\":1,\"list\":null},{\"value\":\"2\",\"number\":2,\"list\":null},{\"value\":\"Fizz\",\"number\":3,\"list\":null},{\"value\":\"4\",\"number\":4,\"list\":null},{\"value\":\"Buzz\",\"number\":5,\"list\":null},{\"value\":\"Fizz\",\"number\":6,\"list\":null},{\"value\":\"7\",\"number\":7,\"list\":null},{\"value\":\"8\",\"number\":8,\"list\":null},{\"value\":\"Fizz\",\"number\":9,\"list\":null},{\"value\":\"Buzz\",\"number\":10,\"list\":null},{\"value\":\"11\",\"number\":11,\"list\":null},{\"value\":\"Fizz\",\"number\":12,\"list\":null},{\"value\":\"13\",\"number\":13,\"list\":null},{\"value\":\"14\",\"number\":14,\"list\":null},{\"value\":\"FizzBuzz\",\"number\":15,\"list\":null},{\"value\":\"16\",\"number\":16,\"list\":null},{\"value\":\"17\",\"number\":17,\"list\":null},{\"value\":\"Fizz\",\"number\":18,\"list\":null},{\"value\":\"19\",\"number\":19,\"list\":null},{\"value\":\"Buzz\",\"number\":20,\"list\":null},{\"value\":\"Fizz\",\"number\":21,\"list\":null},{\"value\":\"22\",\"number\":22,\"list\":null},{\"value\":\"23\",\"number\":23,\"list\":null},{\"value\":\"Fizz\",\"number\":24,\"list\":null},{\"value\":\"Buzz\",\"number\":25,\"list\":null},{\"value\":\"26\",\"number\":26,\"list\":null},{\"value\":\"Fizz\",\"number\":27,\"list\":null},{\"value\":\"28\",\"number\":28,\"list\":null},{\"value\":\"29\",\"number\":29,\"list\":null},{\"value\":\"FizzBuzz\",\"number\":30,\"list\":null},{\"value\":\"31\",\"number\":31,\"list\":null},{\"value\":\"32\",\"number\":32,\"list\":null},{\"value\":\"Fizz\",\"number\":33,\"list\":null},{\"value\":\"34\",\"number\":34,\"list\":null},{\"value\":\"Buzz\",\"number\":35,\"list\":null},{\"value\":\"Fizz\",\"number\":36,\"list\":null},{\"value\":\"37\",\"number\":37,\"list\":null},{\"value\":\"38\",\"number\":38,\"list\":null},{\"value\":\"Fizz\",\"number\":39,\"list\":null},{\"value\":\"Buzz\",\"number\":40,\"list\":null},{\"value\":\"41\",\"number\":41,\"list\":null},{\"value\":\"Fizz\",\"number\":42,\"list\":null},{\"value\":\"43\",\"number\":43,\"list\":null},{\"value\":\"44\",\"number\":44,\"list\":null},{\"value\":\"FizzBuzz\",\"number\":45,\"list\":null},{\"value\":\"46\",\"number\":46,\"list\":null},{\"value\":\"47\",\"number\":47,\"list\":null},{\"value\":\"Fizz\",\"number\":48,\"list\":null},{\"value\":\"49\",\"number\":49,\"list\":null},{\"value\":\"Buzz\",\"number\":50,\"list\":null},{\"value\":\"Fizz\",\"number\":51,\"list\":null},{\"value\":\"52\",\"number\":52,\"list\":null},{\"value\":\"53\",\"number\":53,\"list\":null},{\"value\":\"Fizz\",\"number\":54,\"list\":null},{\"value\":\"Buzz\",\"number\":55,\"list\":null},{\"value\":\"56\",\"number\":56,\"list\":null},{\"value\":\"Fizz\",\"number\":57,\"list\":null},{\"value\":\"58\",\"number\":58,\"list\":null},{\"value\":\"59\",\"number\":59,\"list\":null},{\"value\":\"FizzBuzz\",\"number\":60,\"list\":null},{\"value\":\"61\",\"number\":61,\"list\":null},{\"value\":\"62\",\"number\":62,\"list\":null},{\"value\":\"Fizz\",\"number\":63,\"list\":null},{\"value\":\"64\",\"number\":64,\"list\":null},{\"value\":\"Buzz\",\"number\":65,\"list\":null},{\"value\":\"Fizz\",\"number\":66,\"list\":null},{\"value\":\"67\",\"number\":67,\"list\":null},{\"value\":\"68\",\"number\":68,\"list\":null},{\"value\":\"Fizz\",\"number\":69,\"list\":null},{\"value\":\"Buzz\",\"number\":70,\"list\":null},{\"value\":\"71\",\"number\":71,\"list\":null},{\"value\":\"Fizz\",\"number\":72,\"list\":null},{\"value\":\"73\",\"number\":73,\"list\":null},{\"value\":\"74\",\"number\":74,\"list\":null},{\"value\":\"FizzBuzz\",\"number\":75,\"list\":null},{\"value\":\"76\",\"number\":76,\"list\":null},{\"value\":\"77\",\"number\":77,\"list\":null},{\"value\":\"Fizz\",\"number\":78,\"list\":null},{\"value\":\"79\",\"number\":79,\"list\":null},{\"value\":\"Buzz\",\"number\":80,\"list\":null},{\"value\":\"Fizz\",\"number\":81,\"list\":null},{\"value\":\"82\",\"number\":82,\"list\":null},{\"value\":\"83\",\"number\":83,\"list\":null},{\"value\":\"Fizz\",\"number\":84,\"list\":null},{\"value\":\"Buzz\",\"number\":85,\"list\":null},{\"value\":\"86\",\"number\":86,\"list\":null},{\"value\":\"Fizz\",\"number\":87,\"list\":null},{\"value\":\"88\",\"number\":88,\"list\":null},{\"value\":\"89\",\"number\":89,\"list\":null},{\"value\":\"FizzBuzz\",\"number\":90,\"list\":null},{\"value\":\"91\",\"number\":91,\"list\":null},{\"value\":\"92\",\"number\":92,\"list\":null},{\"value\":\"Fizz\",\"number\":93,\"list\":null},{\"value\":\"94\",\"number\":94,\"list\":null},{\"value\":\"Buzz\",\"number\":95,\"list\":null},{\"value\":\"Fizz\",\"number\":96,\"list\":null},{\"value\":\"97\",\"number\":97,\"list\":null},{\"value\":\"98\",\"number\":98,\"list\":null},{\"value\":\"Fizz\",\"number\":99,\"list\":null},{\"value\":\"Buzz\",\"number\":100,\"list\":null}]"
        )
      )
    );
  }

}

