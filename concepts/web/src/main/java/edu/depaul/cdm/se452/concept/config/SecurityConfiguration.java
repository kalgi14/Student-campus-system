package edu.depaul.cdm.se452.concept.config;

import javax.sql.DataSource;

import edu.depaul.cdm.se452.concept.model.*;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@ComponentScan({"edu.depaul.cdm.se452.concept.model"})
@EntityScan(basePackages = "edu.depaul.cdm.se452.concept.database.mysql.domain")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Bean
    public enrollmentService someBean() {
        return new enrollmentService();
    }

    @Bean
    public TuitionService someBean2() {
        return new TuitionService();
    }

    @Bean
    public CourseCatalogService someBean3() {
        return new CourseCatalogService();
    }

    @Bean
    public GradesService someBean4() {
        return new GradesService();
    }

//    public edu.depaul.cdm.se452.concept.model.IEnrollmentService enrollmentInterface;
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    String password = "adminPassword";
//    String encodedPassword = passwordEncoder.encode(password);


    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
//        System.out.println("Password is         : " + password);
//        System.out.println("Encoded Password is : " + encodedPassword);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll();
    }
}
