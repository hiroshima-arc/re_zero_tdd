package rental;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.time.LocalDate;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StatementControllerTest {
  @Autowired
  private MockMvc mvc;

  @Test
  public void getStatement() throws Exception {
    mvc.perform(
      MockMvcRequestBuilders.get("/text").accept(MediaType.APPLICATION_JSON)
    )
      .andExpect(status().isOk())
      .andExpect(
        content()
          .string(
            equalTo(
              "レンタル記録 山田様 " +
                LocalDate.now() +
                "\n\n新作\t3日間\t900円\t2ポイント\n子供\t2日間\t150円\t1ポイント\n一般\t1日間\t200円\t1ポイント\n\n合計金額 1250円\n獲得ポイント 4ポイント"
            )
          )
      );
  }
}
