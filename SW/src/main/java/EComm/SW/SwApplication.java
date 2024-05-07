package EComm.SW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SwApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SwApplication.class);
		app.setAllowCircularReferences(true); // Enable circular references
		ConfigurableApplicationContext context = app.run(args);
	}

}
