package com.example.demo.util;

import com.example.demo.security.AudienceValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;

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
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/person").permitAll()

                .antMatchers(HttpMethod.GET, "/person/user/info/*").permitAll()
                .antMatchers(HttpMethod.GET, "/person/user/info/email").permitAll()

                .antMatchers(HttpMethod.GET, "/data/last/day/*").permitAll()
                .antMatchers(HttpMethod.GET, "/data/general/*").permitAll()
                .antMatchers(HttpMethod.GET, "/data/general/list/*").permitAll()
                .antMatchers(HttpMethod.GET, "/view/*/list").authenticated()
                .antMatchers(HttpMethod.POST, "/view").hasAuthority("SCOPE_create:user_dashboards")
                .antMatchers(HttpMethod.GET, "/department/general/*").hasAnyAuthority()
                //.anyRequest()
                //.authenticated()
                .and().cors()
                .and().oauth2ResourceServer()
                .jwt();

    }

    @Bean
    JwtDecoder jwtDecoder(OAuth2ResourceServerProperties properties, @Value("${auth0.audience}") String audience) {

        String issuerUri = properties.getJwt().getIssuerUri();
        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuerUri);

        OAuth2TokenValidator<Jwt> audienceValidator = AudienceValidator.of(audience);
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuerUri);
        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

        jwtDecoder.setJwtValidator(withAudience);

        return jwtDecoder;
    }
}
