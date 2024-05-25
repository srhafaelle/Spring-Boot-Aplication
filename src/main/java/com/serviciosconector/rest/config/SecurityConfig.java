/*package com.serviciosconector.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
/*configuartion one
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
            //no inabilitar si uso formularios .csrf().disable()
            .authorizeHttpRequests()
                 .requestMatchers("/security/index").permitAll()//aqui seleccionamos las que queremos permitir
                 .anyRequest().authenticated() //elegimos proteger todo
            .and()
            .formLogin().permitAll()
            .disable()
            httpBasic() //es para enviar en el header la informacion que es inseguro
            .and()
            .build();

    }

    //configuration two lamda expresion using

    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return  httpSecurity
                .authorizeHttpRequests(auth->{
                    auth.requestMatchers("/security/index").permitAll();
                    auth.anyRequest().authenticated();

                })
                .formLogin()
                   .successHandler(successHandler())//redireciona
                   .permitAll()
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)// has always , if , never , stabless
                    .invalidSessionUrl("/login")  //si la sesion es invalidad redirige es un modo de seguridad
                     .maximumSessions(1)
                     .expiredUrl("/login")
                .sessionRegistry(sessionRegistry()) //para administrar registros de la ssion
                .and()
                .sessionFixation()//protege de la vulnerabilidad de robo de id de sesion
                     .migrateSession()//genera otro id sta tambien newSession y none
                .and()
                .build();

    }
    @Bean
    public SessionRegistry sessionRegistry(){
        return  new SessionRegistryImpl();
        //para rrastrear los datos
    }
    public AuthenticationSuccessHandler successHandler(){
        return ((request, response, authentication) -> {
           response.sendRedirect("session");

        });
    }
}
*/