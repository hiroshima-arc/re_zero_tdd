package k2works;

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
      MockMvcRequestBuilders.get("/fizzbuzz/one").accept(
        MediaType.APPLICATION_JSON
      )
    ).andExpect(status().isOk()).andExpect(
      content().string(
        equalTo(
          "[{\"value\":\"1\",\"number\":1,\"values\":[]},{\"value\":\"2\",\"number\":2,\"values\":[]},{\"value\":\"Fizz\",\"number\":3,\"values\":[]},{\"value\":\"4\",\"number\":4,\"values\":[]},{\"value\":\"Buzz\",\"number\":5,\"values\":[]},{\"value\":\"Fizz\",\"number\":6,\"values\":[]},{\"value\":\"7\",\"number\":7,\"values\":[]},{\"value\":\"8\",\"number\":8,\"values\":[]},{\"value\":\"Fizz\",\"number\":9,\"values\":[]},{\"value\":\"Buzz\",\"number\":10,\"values\":[]},{\"value\":\"11\",\"number\":11,\"values\":[]},{\"value\":\"Fizz\",\"number\":12,\"values\":[]},{\"value\":\"13\",\"number\":13,\"values\":[]},{\"value\":\"14\",\"number\":14,\"values\":[]},{\"value\":\"FizzBuzz\",\"number\":15,\"values\":[]},{\"value\":\"16\",\"number\":16,\"values\":[]},{\"value\":\"17\",\"number\":17,\"values\":[]},{\"value\":\"Fizz\",\"number\":18,\"values\":[]},{\"value\":\"19\",\"number\":19,\"values\":[]},{\"value\":\"Buzz\",\"number\":20,\"values\":[]},{\"value\":\"Fizz\",\"number\":21,\"values\":[]},{\"value\":\"22\",\"number\":22,\"values\":[]},{\"value\":\"23\",\"number\":23,\"values\":[]},{\"value\":\"Fizz\",\"number\":24,\"values\":[]},{\"value\":\"Buzz\",\"number\":25,\"values\":[]},{\"value\":\"26\",\"number\":26,\"values\":[]},{\"value\":\"Fizz\",\"number\":27,\"values\":[]},{\"value\":\"28\",\"number\":28,\"values\":[]},{\"value\":\"29\",\"number\":29,\"values\":[]},{\"value\":\"FizzBuzz\",\"number\":30,\"values\":[]},{\"value\":\"31\",\"number\":31,\"values\":[]},{\"value\":\"32\",\"number\":32,\"values\":[]},{\"value\":\"Fizz\",\"number\":33,\"values\":[]},{\"value\":\"34\",\"number\":34,\"values\":[]},{\"value\":\"Buzz\",\"number\":35,\"values\":[]},{\"value\":\"Fizz\",\"number\":36,\"values\":[]},{\"value\":\"37\",\"number\":37,\"values\":[]},{\"value\":\"38\",\"number\":38,\"values\":[]},{\"value\":\"Fizz\",\"number\":39,\"values\":[]},{\"value\":\"Buzz\",\"number\":40,\"values\":[]},{\"value\":\"41\",\"number\":41,\"values\":[]},{\"value\":\"Fizz\",\"number\":42,\"values\":[]},{\"value\":\"43\",\"number\":43,\"values\":[]},{\"value\":\"44\",\"number\":44,\"values\":[]},{\"value\":\"FizzBuzz\",\"number\":45,\"values\":[]},{\"value\":\"46\",\"number\":46,\"values\":[]},{\"value\":\"47\",\"number\":47,\"values\":[]},{\"value\":\"Fizz\",\"number\":48,\"values\":[]},{\"value\":\"49\",\"number\":49,\"values\":[]},{\"value\":\"Buzz\",\"number\":50,\"values\":[]},{\"value\":\"Fizz\",\"number\":51,\"values\":[]},{\"value\":\"52\",\"number\":52,\"values\":[]},{\"value\":\"53\",\"number\":53,\"values\":[]},{\"value\":\"Fizz\",\"number\":54,\"values\":[]},{\"value\":\"Buzz\",\"number\":55,\"values\":[]},{\"value\":\"56\",\"number\":56,\"values\":[]},{\"value\":\"Fizz\",\"number\":57,\"values\":[]},{\"value\":\"58\",\"number\":58,\"values\":[]},{\"value\":\"59\",\"number\":59,\"values\":[]},{\"value\":\"FizzBuzz\",\"number\":60,\"values\":[]},{\"value\":\"61\",\"number\":61,\"values\":[]},{\"value\":\"62\",\"number\":62,\"values\":[]},{\"value\":\"Fizz\",\"number\":63,\"values\":[]},{\"value\":\"64\",\"number\":64,\"values\":[]},{\"value\":\"Buzz\",\"number\":65,\"values\":[]},{\"value\":\"Fizz\",\"number\":66,\"values\":[]},{\"value\":\"67\",\"number\":67,\"values\":[]},{\"value\":\"68\",\"number\":68,\"values\":[]},{\"value\":\"Fizz\",\"number\":69,\"values\":[]},{\"value\":\"Buzz\",\"number\":70,\"values\":[]},{\"value\":\"71\",\"number\":71,\"values\":[]},{\"value\":\"Fizz\",\"number\":72,\"values\":[]},{\"value\":\"73\",\"number\":73,\"values\":[]},{\"value\":\"74\",\"number\":74,\"values\":[]},{\"value\":\"FizzBuzz\",\"number\":75,\"values\":[]},{\"value\":\"76\",\"number\":76,\"values\":[]},{\"value\":\"77\",\"number\":77,\"values\":[]},{\"value\":\"Fizz\",\"number\":78,\"values\":[]},{\"value\":\"79\",\"number\":79,\"values\":[]},{\"value\":\"Buzz\",\"number\":80,\"values\":[]},{\"value\":\"Fizz\",\"number\":81,\"values\":[]},{\"value\":\"82\",\"number\":82,\"values\":[]},{\"value\":\"83\",\"number\":83,\"values\":[]},{\"value\":\"Fizz\",\"number\":84,\"values\":[]},{\"value\":\"Buzz\",\"number\":85,\"values\":[]},{\"value\":\"86\",\"number\":86,\"values\":[]},{\"value\":\"Fizz\",\"number\":87,\"values\":[]},{\"value\":\"88\",\"number\":88,\"values\":[]},{\"value\":\"89\",\"number\":89,\"values\":[]},{\"value\":\"FizzBuzz\",\"number\":90,\"values\":[]},{\"value\":\"91\",\"number\":91,\"values\":[]},{\"value\":\"92\",\"number\":92,\"values\":[]},{\"value\":\"Fizz\",\"number\":93,\"values\":[]},{\"value\":\"94\",\"number\":94,\"values\":[]},{\"value\":\"Buzz\",\"number\":95,\"values\":[]},{\"value\":\"Fizz\",\"number\":96,\"values\":[]},{\"value\":\"97\",\"number\":97,\"values\":[]},{\"value\":\"98\",\"number\":98,\"values\":[]},{\"value\":\"Fizz\",\"number\":99,\"values\":[]},{\"value\":\"Buzz\",\"number\":100,\"values\":[]}]"
        )
      )
    );
  }

}

