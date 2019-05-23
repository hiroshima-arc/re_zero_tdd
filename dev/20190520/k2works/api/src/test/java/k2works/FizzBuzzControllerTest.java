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
      MockMvcRequestBuilders.get("/fizzbuzz").accept(MediaType.APPLICATION_JSON)
    ).andExpect(status().isOk()).andExpect(
      content().string(
        equalTo(
          "[{\"value\":\"1\",\"number\":1,\"values\":null},{\"value\":\"2\",\"number\":2,\"values\":null},{\"value\":\"Fizz\",\"number\":3,\"values\":null},{\"value\":\"4\",\"number\":4,\"values\":null},{\"value\":\"Buzz\",\"number\":5,\"values\":null},{\"value\":\"Fizz\",\"number\":6,\"values\":null},{\"value\":\"7\",\"number\":7,\"values\":null},{\"value\":\"8\",\"number\":8,\"values\":null},{\"value\":\"Fizz\",\"number\":9,\"values\":null},{\"value\":\"Buzz\",\"number\":10,\"values\":null},{\"value\":\"11\",\"number\":11,\"values\":null},{\"value\":\"Fizz\",\"number\":12,\"values\":null},{\"value\":\"13\",\"number\":13,\"values\":null},{\"value\":\"14\",\"number\":14,\"values\":null},{\"value\":\"FizzBuzz\",\"number\":15,\"values\":null},{\"value\":\"16\",\"number\":16,\"values\":null},{\"value\":\"17\",\"number\":17,\"values\":null},{\"value\":\"Fizz\",\"number\":18,\"values\":null},{\"value\":\"19\",\"number\":19,\"values\":null},{\"value\":\"Buzz\",\"number\":20,\"values\":null},{\"value\":\"Fizz\",\"number\":21,\"values\":null},{\"value\":\"22\",\"number\":22,\"values\":null},{\"value\":\"23\",\"number\":23,\"values\":null},{\"value\":\"Fizz\",\"number\":24,\"values\":null},{\"value\":\"Buzz\",\"number\":25,\"values\":null},{\"value\":\"26\",\"number\":26,\"values\":null},{\"value\":\"Fizz\",\"number\":27,\"values\":null},{\"value\":\"28\",\"number\":28,\"values\":null},{\"value\":\"29\",\"number\":29,\"values\":null},{\"value\":\"FizzBuzz\",\"number\":30,\"values\":null},{\"value\":\"31\",\"number\":31,\"values\":null},{\"value\":\"32\",\"number\":32,\"values\":null},{\"value\":\"Fizz\",\"number\":33,\"values\":null},{\"value\":\"34\",\"number\":34,\"values\":null},{\"value\":\"Buzz\",\"number\":35,\"values\":null},{\"value\":\"Fizz\",\"number\":36,\"values\":null},{\"value\":\"37\",\"number\":37,\"values\":null},{\"value\":\"38\",\"number\":38,\"values\":null},{\"value\":\"Fizz\",\"number\":39,\"values\":null},{\"value\":\"Buzz\",\"number\":40,\"values\":null},{\"value\":\"41\",\"number\":41,\"values\":null},{\"value\":\"Fizz\",\"number\":42,\"values\":null},{\"value\":\"43\",\"number\":43,\"values\":null},{\"value\":\"44\",\"number\":44,\"values\":null},{\"value\":\"FizzBuzz\",\"number\":45,\"values\":null},{\"value\":\"46\",\"number\":46,\"values\":null},{\"value\":\"47\",\"number\":47,\"values\":null},{\"value\":\"Fizz\",\"number\":48,\"values\":null},{\"value\":\"49\",\"number\":49,\"values\":null},{\"value\":\"Buzz\",\"number\":50,\"values\":null},{\"value\":\"Fizz\",\"number\":51,\"values\":null},{\"value\":\"52\",\"number\":52,\"values\":null},{\"value\":\"53\",\"number\":53,\"values\":null},{\"value\":\"Fizz\",\"number\":54,\"values\":null},{\"value\":\"Buzz\",\"number\":55,\"values\":null},{\"value\":\"56\",\"number\":56,\"values\":null},{\"value\":\"Fizz\",\"number\":57,\"values\":null},{\"value\":\"58\",\"number\":58,\"values\":null},{\"value\":\"59\",\"number\":59,\"values\":null},{\"value\":\"FizzBuzz\",\"number\":60,\"values\":null},{\"value\":\"61\",\"number\":61,\"values\":null},{\"value\":\"62\",\"number\":62,\"values\":null},{\"value\":\"Fizz\",\"number\":63,\"values\":null},{\"value\":\"64\",\"number\":64,\"values\":null},{\"value\":\"Buzz\",\"number\":65,\"values\":null},{\"value\":\"Fizz\",\"number\":66,\"values\":null},{\"value\":\"67\",\"number\":67,\"values\":null},{\"value\":\"68\",\"number\":68,\"values\":null},{\"value\":\"Fizz\",\"number\":69,\"values\":null},{\"value\":\"Buzz\",\"number\":70,\"values\":null},{\"value\":\"71\",\"number\":71,\"values\":null},{\"value\":\"Fizz\",\"number\":72,\"values\":null},{\"value\":\"73\",\"number\":73,\"values\":null},{\"value\":\"74\",\"number\":74,\"values\":null},{\"value\":\"FizzBuzz\",\"number\":75,\"values\":null},{\"value\":\"76\",\"number\":76,\"values\":null},{\"value\":\"77\",\"number\":77,\"values\":null},{\"value\":\"Fizz\",\"number\":78,\"values\":null},{\"value\":\"79\",\"number\":79,\"values\":null},{\"value\":\"Buzz\",\"number\":80,\"values\":null},{\"value\":\"Fizz\",\"number\":81,\"values\":null},{\"value\":\"82\",\"number\":82,\"values\":null},{\"value\":\"83\",\"number\":83,\"values\":null},{\"value\":\"Fizz\",\"number\":84,\"values\":null},{\"value\":\"Buzz\",\"number\":85,\"values\":null},{\"value\":\"86\",\"number\":86,\"values\":null},{\"value\":\"Fizz\",\"number\":87,\"values\":null},{\"value\":\"88\",\"number\":88,\"values\":null},{\"value\":\"89\",\"number\":89,\"values\":null},{\"value\":\"FizzBuzz\",\"number\":90,\"values\":null},{\"value\":\"91\",\"number\":91,\"values\":null},{\"value\":\"92\",\"number\":92,\"values\":null},{\"value\":\"Fizz\",\"number\":93,\"values\":null},{\"value\":\"94\",\"number\":94,\"values\":null},{\"value\":\"Buzz\",\"number\":95,\"values\":null},{\"value\":\"Fizz\",\"number\":96,\"values\":null},{\"value\":\"97\",\"number\":97,\"values\":null},{\"value\":\"98\",\"number\":98,\"values\":null},{\"value\":\"Fizz\",\"number\":99,\"values\":null},{\"value\":\"Buzz\",\"number\":100,\"values\":null}]"
        )
      )
    );
  }

}

