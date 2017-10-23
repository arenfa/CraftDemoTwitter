package craftdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//		authenticationMgr.inMemoryAuthentication()
//			.withUser("journaldev")
//			.password("jd@123")
//			.authorities("ROLE_USER");
		
		// uid=tesla,dc=example,dc=com
		// ldap://ldap.forumsys.com:389/uid=tesla,dc=example,dc=com
		
//		authenticationMgr.ldapAuthentication().userDnPatterns("uid={0},dc=example,dc=com").contextSource()
//			.url("ldap://ldap.forumsys.com:389/dc=example,dc=com").and().passwordCompare();
//		
//		String aaa = "{0}";
//		System.out.println("ldap user: " + aaa);

//			.and()
//		.passwordCompare()
//			.passwordEncoder(new LdapShaPasswordEncoder())
//			.passwordAttribute("userPassword");
		
//		 authenticationMgr.ldapAuthentication()
//		 	.userDnPatterns("uid={0},ou=people")
//			.groupSearchBase("ou=groups")
//		 	.contextSource()
//		 	.root("dc=springframework,dc=com").ldif("classpath:test-server.ldif");
		 
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
