package infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ApiConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry){
                corsRegistry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET","PUT","POST","DELETE")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.disable())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
//                .requestMatchers(HttpMethod.GET,"/**").permitAll() // allow access to public path
                .requestMatchers(HttpMethod.POST,"/login").permitAll()
                .requestMatchers("/error","/public").permitAll()
                // Allow all roles to access GET endpoints
                .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("USER", "TECH", "ADMIN")

                // Incident access rules
//                .requestMatchers(HttpMethod.GET, "/incidents/**").hasAnyRole("USER", "TECH", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/incidents/**").hasAnyRole("USER", "TECH")
                .requestMatchers(HttpMethod.PUT, "/incidents/**").hasRole("TECH")

                // Only USER can post appreciations
                .requestMatchers(HttpMethod.POST, "/appreciations/**").hasRole("USER")

                // Only TECH can post interventions
                .requestMatchers(HttpMethod.POST, "/interventions/**").hasRole("TECH")

                // All other endpoints require ADMIN role
                .requestMatchers("/**").hasRole("ADMIN"))
                 .formLogin(form->form.disable())
                .logout(logout->logout.disable())
                 .httpBasic(withDefaults())  // enable http basic authentication
//                .logout(withDefaults())
        ;
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails tech=User.withUsername("tech")
                .password(encoder.encode("tech"))
                .roles("TECH")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin,tech);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
