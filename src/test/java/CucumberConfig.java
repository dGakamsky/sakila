import org.springframework.boot.test.context.SpringBootTest;
import sakila_api.sakila.SakilaApplication;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = SakilaApplication.class )
public class CucumberConfig {
}
