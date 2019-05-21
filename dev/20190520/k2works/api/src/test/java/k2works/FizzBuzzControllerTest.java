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
          "[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\",\"Fizz\",\"7\",\"8\",\"Fizz\",\"Buzz\",\"11\",\"Fizz\",\"13\",\"14\",\"FizzBuzz\",\"16\",\"17\",\"Fizz\",\"19\",\"Buzz\",\"Fizz\",\"22\",\"23\",\"Fizz\",\"Buzz\",\"26\",\"Fizz\",\"28\",\"29\",\"FizzBuzz\",\"31\",\"32\",\"Fizz\",\"34\",\"Buzz\",\"Fizz\",\"37\",\"38\",\"Fizz\",\"Buzz\",\"41\",\"Fizz\",\"43\",\"44\",\"FizzBuzz\",\"46\",\"47\",\"Fizz\",\"49\",\"Buzz\",\"Fizz\",\"52\",\"53\",\"Fizz\",\"Buzz\",\"56\",\"Fizz\",\"58\",\"59\",\"FizzBuzz\",\"61\",\"62\",\"Fizz\",\"64\",\"Buzz\",\"Fizz\",\"67\",\"68\",\"Fizz\",\"Buzz\",\"71\",\"Fizz\",\"73\",\"74\",\"FizzBuzz\",\"76\",\"77\",\"Fizz\",\"79\",\"Buzz\",\"Fizz\",\"82\",\"83\",\"Fizz\",\"Buzz\",\"86\",\"Fizz\",\"88\",\"89\",\"FizzBuzz\",\"91\",\"92\",\"Fizz\",\"94\",\"Buzz\",\"Fizz\",\"97\",\"98\",\"Fizz\",\"Buzz\"]"
        )
      )
    );
  }

}

