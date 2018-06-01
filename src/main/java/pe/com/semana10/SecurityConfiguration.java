package pe.com.semana10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder amb) throws Exception {
		amb
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/genero/**").permitAll()
				.antMatchers("/editorial/**").permitAll()
				.antMatchers("/libro/**").permitAll()
				//.antMatchers("/autoresLibro/{id}").permitAll()
				.antMatchers("/autoresLibro/**").permitAll()
				.antMatchers("/admin/login").permitAll()
				.antMatchers("/admin/**").hasAuthority("Usuario").anyRequest()
				.authenticated().and().csrf().disable().formLogin()
				.loginPage("/admin/login").failureUrl("/admin/login?error=true")
				.defaultSuccessUrl("/admin/dashboard")
				.usernameParameter("correo")
				.passwordParameter("clave")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
				.logoutSuccessUrl("/admin/login").and().exceptionHandling()
				.accessDeniedPage("/admin/denied");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}	
}
