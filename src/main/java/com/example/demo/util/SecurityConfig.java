package com.example.demo.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//    private String issuer;
//
//    @Value("${auth0.audience}")
//    private String audience;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /*
        This is where we configure the security required for our endpoints and setup our app to serve as
        an OAuth2 Resource Server, using JWT validation.
        */
        http.cors()
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/data/last/day/*").permitAll()
                .antMatchers(HttpMethod.GET, "/data/general/*").permitAll()
                .antMatchers(HttpMethod.GET, "/data/general/list/*").permitAll()
                .antMatchers(HttpMethod.GET, "/view/*/list").authenticated()
                .antMatchers(HttpMethod.POST, "/view").hasAuthority("SCOPE_create:user_dashboards")
                .anyRequest()
                .authenticated().and().oauth2ResourceServer()
                .jwt();
    }

//    @Bean
//    ReactiveJwtDecoder jwtDecoder() {
//        /*
//        By default, Spring Security does not validate the "aud" claim of the token, to ensure that this token is
//        indeed intended for our app. Adding our own validator is easy to do:
//        */
//
//        NimbusReactiveJwtDecoder jwtDecoder = (NimbusReactiveJwtDecoder)
//                ReactiveJwtDecoders.fromOidcIssuerLocation(issuer);
//
//        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
//        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
//        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator,
//                new JwtTimestampValidator());
//
//        jwtDecoder.setJwtValidator(withAudience);
//
//        return jwtDecoder;
//    }
}
