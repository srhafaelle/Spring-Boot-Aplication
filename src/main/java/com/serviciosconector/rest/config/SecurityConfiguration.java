package com.serviciosconector.rest.config;

import com.serviciosconector.rest.models.security.filters.JwtAuthenticationFilter;
import com.serviciosconector.rest.models.security.filters.JwtAuthorizationFilter;
import com.serviciosconector.rest.models.security.jwp.JwtUtils;
import com.serviciosconector.rest.services.implems.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    JwtAuthorizationFilter authorizationFilter;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws  Exception{

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        //jwtAuthenticationFilter.setFilterProcessesUrl("login"); para cambiar la ruta que viene por defecto

            return  httpSecurity
                    .csrf(config -> config.disable())
                    .authorizeHttpRequests(auth ->{
                        auth.requestMatchers("/index").permitAll();
                        auth.requestMatchers("/accesAdmin").hasAnyRole("ADMIN", "USER");//aqui damos por roles los accesos esta es una forma
                       // auth.requestMatchers("/accesInvited").hasRole("INVITED");
                        auth.anyRequest().authenticated();

                    })
                    .sessionManagement(session->{
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                    })
                   //.httpBasic()
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
//aqui configuramos el comportamiento de acceso a los endpoint manejo de sesion y autenticacion basica que creamos en memoria

    }
    /*
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("Sergio")
                .password("21235022")
                .roles()
                .build());
        return manager;
        //aqui creamos el usuario para poder ingresar a la seguridad basica pero debe ser administrado por algun objeto para que funcione
    }
    comentamos porque esto setea usuario en memoria vamos acrear una funcion para recuperar el usuario de la base de datops
     */

    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
      //  return NoOpPasswordEncoder.getInstance();//para no manejar por ahora la encriptacion
        //creamos el password encoder encriptado
    }
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws  Exception{
                return  httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                        .userDetailsService(userDetailsService)
                        .passwordEncoder(passwordEncoder)
                        .and().build();
                //aqui creamos el objeto administrador del usuario para sarlo a la configuracion basica
    }

}
