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
      content().string(equalTo("[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\"]"))
    );
  }

}

