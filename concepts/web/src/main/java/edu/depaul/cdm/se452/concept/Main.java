package edu.depaul.cdm.se452.concept;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Sample to demonstrate profile (application-dev vs application-prod)
 */

//@ComponentScan({"edu.depaul.cdm.se452.concept.model"})
@SpringBootApplication
//@EntityScan("edu.depaul.cdm.se452.concept.database.mysql.domain")
//@EnableJpaRepositories("edu.depaul.cdm.se452.concept.database.mysql.repository")
public class Main {
    @Value( "${spring.profiles.active}" )
    private String env;

    @Bean
    public CommandLineRunner showMessage() {
      return (args) -> {
        System.out.println(env);
      };
    }    
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

}