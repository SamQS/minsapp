
package springboot.minsa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
*/
public class SpringSecurityCofig {
/*
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/imagenes/**").permitAll().antMatchers("/home/**")
				.hasAnyRole("ADMIN").antMatchers("/listar/**")
				.hasAnyRole("ADMIN").antMatchers("/form/**")
				.hasAnyRole("USER_ADMINISTRATIVO_EXTERNO").antMatchers("/menuAsistencial/**")
				.hasAnyRole("USER_ADMINISTRATIVO_EXTERNO").antMatchers("/listarServicios/**")
				.hasAnyRole("USER_ADMINISTRATIVO_EXTERNO").antMatchers("/registrarServicio/**")
				.hasAnyRole("USER_ADMINISTRATIVO_EXTERNO").antMatchers("/verServicio/**")
				.hasAnyRole("USER_ADMINISTRATIVO_EXTERNO").antMatchers("/listarCentros/**")
				.hasAnyRole("USER_ADMINISTRATIVO_EXTERNO").antMatchers("/registrarCentro/**")
				.hasAnyRole("USER_ADMINISTRATIVO_EXTERNO").antMatchers("/ver/**")
				.hasAnyRole("ADMIN").anyRequest().authenticated().and()
				.formLogin().loginPage("/login")
				.permitAll().and().logout()
				.permitAll();
		return http.build();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withUsername("47445223").password(passwordEncoder().encode("alexquispe")).roles("USER_ASISTENCIAL").build());
		manager.createUser(
				User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());
		manager.createUser(
				User.withUsername("11110000").password(passwordEncoder().encode("fernando")).roles("USER_ADMINISTRATIVO_EXTERNO").build());
		
		return manager;
	}
*/
}