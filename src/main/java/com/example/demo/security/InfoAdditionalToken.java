package com.example.demo.security;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Persons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InfoAdditionalToken implements TokenEnhancer {


    private PersonRepository personRepository;

    @Autowired
    public InfoAdditionalToken(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoAdditionalToken.class);

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        Map<String, Object> info = new HashMap<>();
        Persons userM = personRepository.findUserByUserName(oAuth2Authentication.getName());
        LOGGER.warn(userM.toString());
        info.put("idUser", userM.getIdUser());
        info.put("username", userM.getUsername());
        List<String> role = new ArrayList<>();
        role.add(userM.getRole());
        info.put("role", role);
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}