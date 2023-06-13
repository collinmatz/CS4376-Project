package SearchEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="SearchEngine")
public class SearchEngineApplication {
	public static void main(String[] args) {
		SpringApplication.run(SearchEngineApplication.class, args);
	}
}
