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
          "[{\"value\":\"1\",\"number\":1},{\"value\":\"2\",\"number\":2},{\"value\":\"Fizz\",\"number\":3},{\"value\":\"4\",\"number\":4},{\"value\":\"Buzz\",\"number\":5},{\"value\":\"Fizz\",\"number\":6},{\"value\":\"7\",\"number\":7},{\"value\":\"8\",\"number\":8},{\"value\":\"Fizz\",\"number\":9},{\"value\":\"Buzz\",\"number\":10},{\"value\":\"11\",\"number\":11},{\"value\":\"Fizz\",\"number\":12},{\"value\":\"13\",\"number\":13},{\"value\":\"14\",\"number\":14},{\"value\":\"FizzBuzz\",\"number\":15},{\"value\":\"16\",\"number\":16},{\"value\":\"17\",\"number\":17},{\"value\":\"Fizz\",\"number\":18},{\"value\":\"19\",\"number\":19},{\"value\":\"Buzz\",\"number\":20},{\"value\":\"Fizz\",\"number\":21},{\"value\":\"22\",\"number\":22},{\"value\":\"23\",\"number\":23},{\"value\":\"Fizz\",\"number\":24},{\"value\":\"Buzz\",\"number\":25},{\"value\":\"26\",\"number\":26},{\"value\":\"Fizz\",\"number\":27},{\"value\":\"28\",\"number\":28},{\"value\":\"29\",\"number\":29},{\"value\":\"FizzBuzz\",\"number\":30},{\"value\":\"31\",\"number\":31},{\"value\":\"32\",\"number\":32},{\"value\":\"Fizz\",\"number\":33},{\"value\":\"34\",\"number\":34},{\"value\":\"Buzz\",\"number\":35},{\"value\":\"Fizz\",\"number\":36},{\"value\":\"37\",\"number\":37},{\"value\":\"38\",\"number\":38},{\"value\":\"Fizz\",\"number\":39},{\"value\":\"Buzz\",\"number\":40},{\"value\":\"41\",\"number\":41},{\"value\":\"Fizz\",\"number\":42},{\"value\":\"43\",\"number\":43},{\"value\":\"44\",\"number\":44},{\"value\":\"FizzBuzz\",\"number\":45},{\"value\":\"46\",\"number\":46},{\"value\":\"47\",\"number\":47},{\"value\":\"Fizz\",\"number\":48},{\"value\":\"49\",\"number\":49},{\"value\":\"Buzz\",\"number\":50},{\"value\":\"Fizz\",\"number\":51},{\"value\":\"52\",\"number\":52},{\"value\":\"53\",\"number\":53},{\"value\":\"Fizz\",\"number\":54},{\"value\":\"Buzz\",\"number\":55},{\"value\":\"56\",\"number\":56},{\"value\":\"Fizz\",\"number\":57},{\"value\":\"58\",\"number\":58},{\"value\":\"59\",\"number\":59},{\"value\":\"FizzBuzz\",\"number\":60},{\"value\":\"61\",\"number\":61},{\"value\":\"62\",\"number\":62},{\"value\":\"Fizz\",\"number\":63},{\"value\":\"64\",\"number\":64},{\"value\":\"Buzz\",\"number\":65},{\"value\":\"Fizz\",\"number\":66},{\"value\":\"67\",\"number\":67},{\"value\":\"68\",\"number\":68},{\"value\":\"Fizz\",\"number\":69},{\"value\":\"Buzz\",\"number\":70},{\"value\":\"71\",\"number\":71},{\"value\":\"Fizz\",\"number\":72},{\"value\":\"73\",\"number\":73},{\"value\":\"74\",\"number\":74},{\"value\":\"FizzBuzz\",\"number\":75},{\"value\":\"76\",\"number\":76},{\"value\":\"77\",\"number\":77},{\"value\":\"Fizz\",\"number\":78},{\"value\":\"79\",\"number\":79},{\"value\":\"Buzz\",\"number\":80},{\"value\":\"Fizz\",\"number\":81},{\"value\":\"82\",\"number\":82},{\"value\":\"83\",\"number\":83},{\"value\":\"Fizz\",\"number\":84},{\"value\":\"Buzz\",\"number\":85},{\"value\":\"86\",\"number\":86},{\"value\":\"Fizz\",\"number\":87},{\"value\":\"88\",\"number\":88},{\"value\":\"89\",\"number\":89},{\"value\":\"FizzBuzz\",\"number\":90},{\"value\":\"91\",\"number\":91},{\"value\":\"92\",\"number\":92},{\"value\":\"Fizz\",\"number\":93},{\"value\":\"94\",\"number\":94},{\"value\":\"Buzz\",\"number\":95},{\"value\":\"Fizz\",\"number\":96},{\"value\":\"97\",\"number\":97},{\"value\":\"98\",\"number\":98},{\"value\":\"Fizz\",\"number\":99},{\"value\":\"Buzz\",\"number\":100}]"
        )
      )
    );
  }

}

