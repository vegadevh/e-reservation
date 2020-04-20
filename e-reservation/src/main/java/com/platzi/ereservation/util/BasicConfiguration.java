/**
 * 
 */
package com.platzi.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author vegad
 *
 */

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter{
	protected void configure(HttpSecurity http) throws Exception {
		
		//Cuando implementas este último, se activa la protección CSRF en toda tu aplicación
		//por lo tanto en cada formulario que se rellene, se debe de incluir(al menos en el caso
		//de trabajar con JSP y taglib de spring security) un token específico, en caso contrario 
		//Spring Security no me deja proceder la petición.
		http.csrf().disable();
		
		//formLogin ----De no ser configurado generara clave de seguridad para usuario 'admin'
		
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.httpBasic();
	}
}
