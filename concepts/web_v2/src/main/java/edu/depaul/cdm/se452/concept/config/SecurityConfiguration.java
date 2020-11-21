package edu.depaul.cdm.se452.concept.config;

import javax.sql.DataSource;

import edu.depaul.cdm.se452.concept.controller.services.implimentation.EnrollmentService;
import edu.depaul.cdm.se452.concept.controller.services.implimentation.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan({"edu.depaul.cdm.se452.concept.model"})
@EntityScan(basePackages = "edu.depaul.cdm.se452.concept.controller.database.mysql.domain")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Bean
    public EnrollmentService someBean() {
        return new EnrollmentService();
    }

//    public edu.depaul.cdm.se452.concept.controller.services.interfaces.IProfessorService.IEnrollmentService enrollmentInterface;
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
