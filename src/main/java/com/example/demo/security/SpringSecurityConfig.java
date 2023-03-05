package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.dao.UserDataRepo;
import com.example.demo.model.UserData;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	UserDataRepo repo;
 

    @Bean
    public PasswordEncoder getBcryptPasswordEncoder() {

        return new BCryptPasswordEncoder();

    }

 

    
    @Bean
    public void get() {
    	
    	PasswordEncoder pe = getBcryptPasswordEncoder();
    	
    	
    	if(repo.findByuserName("Jan") == null)
    	{
        	UserData user1 = new UserData();
        	user1.setUserName("Jan");
        	user1.setPassword(pe.encode("123"));
        			

        	repo.save(user1);
    		
    	}
    	
    	
    	if(repo.findByuserName("123") == null)
    	{
        	UserData user1 = new UserData();
        	user1.setUserName("123");
        	user1.setPassword(pe.encode("123"));

        	repo.save(user1);
    		
    	}

    	
    	
    }
    

 

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.csrf()
        .disable()
        .authorizeRequests((autz) -> autz
                .requestMatchers("/main").authenticated()
                .requestMatchers("/getGames").authenticated()
        )
        .formLogin((formLogin) -> formLogin.permitAll())
        .logout().permitAll();
        return http.build();

    }
    
    
    
    
    
    
    /*public static String getUserName() {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	String username = principal.toString();

    	
    	
    	return username;
    }*/
    
    
    public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()));
    }

    private static String extractPrincipal(Authentication authentication) {
        if (authentication == null) {
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
            return springSecurityUser.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            return (String) authentication.getPrincipal();
        }
        return null;
    }


    public static Optional<Authentication> getAuthenticatedCurrentUser() {
        

        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication());
    }
    

}