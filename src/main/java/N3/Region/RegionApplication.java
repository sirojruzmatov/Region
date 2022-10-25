package N3.Region;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionApplication.class, args);

//		SpringApplication application = new SpringApplication(RegionApplication.class);
//		application.setAdditionalProfiles(args[0]); //profile property
//		System.getProperties().setProperty("server.port", args[1]);
//
//		application.run(args);

	}

}
