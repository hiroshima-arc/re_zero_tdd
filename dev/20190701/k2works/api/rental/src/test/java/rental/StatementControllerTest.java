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
      MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)
    )
      .andExpect(status().isOk())
      .andExpect(
        content()
          .string(
            equalTo(
              "山田様のレンタル明細\n\t新作\t900円\n\t子供\t150円\n\t一般\t200円\n合計金額 1250円\n獲得ポイント 4ポイント"
            )
          )
      );
  }
}
