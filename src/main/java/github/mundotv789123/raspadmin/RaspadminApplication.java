package github.mundotv789123.raspadmin;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import jakarta.annotation.PostConstruct;

@EnableScheduling
@EnableJpaRepositories
@SpringBootApplication
public class RaspadminApplication {

    @Value("${application.timezone:null}")
    private String applicationTimeZone;

	public static void main(String[] args) {
		SpringApplication.run(RaspadminApplication.class, args);
	}

	@PostConstruct
    public void executeAfterMain() {
		if (applicationTimeZone != null) {
			TimeZone.setDefault(TimeZone.getTimeZone(applicationTimeZone));
		}
    }
}
