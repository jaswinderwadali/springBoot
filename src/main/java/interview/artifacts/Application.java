package interview.artifacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.interview.model.UserModel;

 
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class })
@SpringBootApplication
@ComponentScan(basePackageClasses = RestService.class)
@PropertySource("classpath:mongo.properties")
public class Application implements CommandLineRunner {

	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		UserModel model = new UserModel();
		model.email = "admin@email.com";
		model.firstName = "Admin";
		model.password = "Admin";
		repository.save(model);
	}
}
