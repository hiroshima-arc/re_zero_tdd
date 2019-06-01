package fizzbuzz.presentation.controller;

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
          "[{\"value\":\"1\",\"number\":1,\"list\":[]},{\"value\":\"2\",\"number\":2,\"list\":[]},{\"value\":\"Fizz\",\"number\":3,\"list\":[]},{\"value\":\"4\",\"number\":4,\"list\":[]},{\"value\":\"Buzz\",\"number\":5,\"list\":[]},{\"value\":\"Fizz\",\"number\":6,\"list\":[]},{\"value\":\"7\",\"number\":7,\"list\":[]},{\"value\":\"8\",\"number\":8,\"list\":[]},{\"value\":\"Fizz\",\"number\":9,\"list\":[]},{\"value\":\"Buzz\",\"number\":10,\"list\":[]},{\"value\":\"11\",\"number\":11,\"list\":[]},{\"value\":\"Fizz\",\"number\":12,\"list\":[]},{\"value\":\"13\",\"number\":13,\"list\":[]},{\"value\":\"14\",\"number\":14,\"list\":[]},{\"value\":\"FizzBuzz\",\"number\":15,\"list\":[]},{\"value\":\"16\",\"number\":16,\"list\":[]},{\"value\":\"17\",\"number\":17,\"list\":[]},{\"value\":\"Fizz\",\"number\":18,\"list\":[]},{\"value\":\"19\",\"number\":19,\"list\":[]},{\"value\":\"Buzz\",\"number\":20,\"list\":[]},{\"value\":\"Fizz\",\"number\":21,\"list\":[]},{\"value\":\"22\",\"number\":22,\"list\":[]},{\"value\":\"23\",\"number\":23,\"list\":[]},{\"value\":\"Fizz\",\"number\":24,\"list\":[]},{\"value\":\"Buzz\",\"number\":25,\"list\":[]},{\"value\":\"26\",\"number\":26,\"list\":[]},{\"value\":\"Fizz\",\"number\":27,\"list\":[]},{\"value\":\"28\",\"number\":28,\"list\":[]},{\"value\":\"29\",\"number\":29,\"list\":[]},{\"value\":\"FizzBuzz\",\"number\":30,\"list\":[]},{\"value\":\"31\",\"number\":31,\"list\":[]},{\"value\":\"32\",\"number\":32,\"list\":[]},{\"value\":\"Fizz\",\"number\":33,\"list\":[]},{\"value\":\"34\",\"number\":34,\"list\":[]},{\"value\":\"Buzz\",\"number\":35,\"list\":[]},{\"value\":\"Fizz\",\"number\":36,\"list\":[]},{\"value\":\"37\",\"number\":37,\"list\":[]},{\"value\":\"38\",\"number\":38,\"list\":[]},{\"value\":\"Fizz\",\"number\":39,\"list\":[]},{\"value\":\"Buzz\",\"number\":40,\"list\":[]},{\"value\":\"41\",\"number\":41,\"list\":[]},{\"value\":\"Fizz\",\"number\":42,\"list\":[]},{\"value\":\"43\",\"number\":43,\"list\":[]},{\"value\":\"44\",\"number\":44,\"list\":[]},{\"value\":\"FizzBuzz\",\"number\":45,\"list\":[]},{\"value\":\"46\",\"number\":46,\"list\":[]},{\"value\":\"47\",\"number\":47,\"list\":[]},{\"value\":\"Fizz\",\"number\":48,\"list\":[]},{\"value\":\"49\",\"number\":49,\"list\":[]},{\"value\":\"Buzz\",\"number\":50,\"list\":[]},{\"value\":\"Fizz\",\"number\":51,\"list\":[]},{\"value\":\"52\",\"number\":52,\"list\":[]},{\"value\":\"53\",\"number\":53,\"list\":[]},{\"value\":\"Fizz\",\"number\":54,\"list\":[]},{\"value\":\"Buzz\",\"number\":55,\"list\":[]},{\"value\":\"56\",\"number\":56,\"list\":[]},{\"value\":\"Fizz\",\"number\":57,\"list\":[]},{\"value\":\"58\",\"number\":58,\"list\":[]},{\"value\":\"59\",\"number\":59,\"list\":[]},{\"value\":\"FizzBuzz\",\"number\":60,\"list\":[]},{\"value\":\"61\",\"number\":61,\"list\":[]},{\"value\":\"62\",\"number\":62,\"list\":[]},{\"value\":\"Fizz\",\"number\":63,\"list\":[]},{\"value\":\"64\",\"number\":64,\"list\":[]},{\"value\":\"Buzz\",\"number\":65,\"list\":[]},{\"value\":\"Fizz\",\"number\":66,\"list\":[]},{\"value\":\"67\",\"number\":67,\"list\":[]},{\"value\":\"68\",\"number\":68,\"list\":[]},{\"value\":\"Fizz\",\"number\":69,\"list\":[]},{\"value\":\"Buzz\",\"number\":70,\"list\":[]},{\"value\":\"71\",\"number\":71,\"list\":[]},{\"value\":\"Fizz\",\"number\":72,\"list\":[]},{\"value\":\"73\",\"number\":73,\"list\":[]},{\"value\":\"74\",\"number\":74,\"list\":[]},{\"value\":\"FizzBuzz\",\"number\":75,\"list\":[]},{\"value\":\"76\",\"number\":76,\"list\":[]},{\"value\":\"77\",\"number\":77,\"list\":[]},{\"value\":\"Fizz\",\"number\":78,\"list\":[]},{\"value\":\"79\",\"number\":79,\"list\":[]},{\"value\":\"Buzz\",\"number\":80,\"list\":[]},{\"value\":\"Fizz\",\"number\":81,\"list\":[]},{\"value\":\"82\",\"number\":82,\"list\":[]},{\"value\":\"83\",\"number\":83,\"list\":[]},{\"value\":\"Fizz\",\"number\":84,\"list\":[]},{\"value\":\"Buzz\",\"number\":85,\"list\":[]},{\"value\":\"86\",\"number\":86,\"list\":[]},{\"value\":\"Fizz\",\"number\":87,\"list\":[]},{\"value\":\"88\",\"number\":88,\"list\":[]},{\"value\":\"89\",\"number\":89,\"list\":[]},{\"value\":\"FizzBuzz\",\"number\":90,\"list\":[]},{\"value\":\"91\",\"number\":91,\"list\":[]},{\"value\":\"92\",\"number\":92,\"list\":[]},{\"value\":\"Fizz\",\"number\":93,\"list\":[]},{\"value\":\"94\",\"number\":94,\"list\":[]},{\"value\":\"Buzz\",\"number\":95,\"list\":[]},{\"value\":\"Fizz\",\"number\":96,\"list\":[]},{\"value\":\"97\",\"number\":97,\"list\":[]},{\"value\":\"98\",\"number\":98,\"list\":[]},{\"value\":\"Fizz\",\"number\":99,\"list\":[]},{\"value\":\"Buzz\",\"number\":100,\"list\":[]}]"
        )
      )
    );
  }

}

