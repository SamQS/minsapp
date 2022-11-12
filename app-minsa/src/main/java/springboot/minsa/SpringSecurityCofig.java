package springboot.minsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityCofig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/imagenes/**", "/status/**").permitAll() //Publico todos los archivos como js/css/imagenes
				.antMatchers("/login*").permitAll()
				.antMatchers("/admin*").hasAnyRole("ADMIN")
				.antMatchers("/userInterno*").hasAnyRole("USER_INTERNO")
				.antMatchers("/userExterno*").hasAnyRole("USER_EXTERNO")
				.antMatchers("/userAsistencial*").hasAnyRole("USER_ASISTENCIAL")
					.anyRequest().authenticated()
					.and()
				.formLogin().
					loginPage("/login").permitAll()
					.defaultSuccessUrl("/menu")
					.failureUrl("/login?error=true")
	                .and()
					.logout()
					.permitAll()
	                .logoutSuccessUrl("/login?logout");

		return http.build();
	}

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception { 
 
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);

    	builder.inMemoryAuthentication()
    	.withUser(users.username("47445223").password("5555").roles("USER_EXTERNO"))
    	.withUser(users.username("01010101").password("1234").roles("USER_INTERNO"))
    	.withUser(users.username("02020202").password("1234").roles("USER_ASISTENCIAL"))
    	.withUser(users.username("80808080").password("1234").roles("ADMIN"));
    }

}