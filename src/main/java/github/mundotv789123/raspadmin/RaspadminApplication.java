package github.mundotv789123.raspadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RaspadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaspadminApplication.class, args);
    }

}
