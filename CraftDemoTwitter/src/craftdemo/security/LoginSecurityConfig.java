package craftdemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author arenfakhourian
 *
 */
@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {

		 authenticationMgr.ldapAuthentication()
		 .userSearchBase("ou=people")
		 .userSearchFilter("(uid={0})")
		 .groupSearchBase("ou=groups")
		 .groupSearchFilter("(member={0})")
		 .contextSource().root("dc=baeldung,dc=com")
		 .ldif("classpath:users.ldif");
    
//		
//		authenticationMgr
//		.ldapAuthentication()
//			.userDnPatterns("uid={0},ou=people")
//			.groupSearchBase("ou=groups")
//			.contextSource()
//				.url("ldap://localhost:8389/dc=springframework,dc=org")
//				.and()
//			.passwordCompare()
//				.passwordEncoder(new LdapShaPasswordEncoder())
//				.passwordAttribute("userPassword");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/homePage").access("hasRole('ROLE_USER')")
			.and()
				.formLogin().loginPage("/loginPage")
				.defaultSuccessUrl("/homePage")
				.failureUrl("/loginPage?error")
				.usernameParameter("username").passwordParameter("password")				
			.and()
				.logout().logoutSuccessUrl("/loginPage?logout"); 
		
	}
}
