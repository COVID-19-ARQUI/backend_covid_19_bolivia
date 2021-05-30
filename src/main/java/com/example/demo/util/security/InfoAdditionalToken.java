package com.example.demo.util.security;


import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Persons;
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

    @Autowired
    private PersonRepository personRepository;


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();

        Persons userM = personRepository.findUserByUserName(oAuth2Authentication.getName());
        info.put("userId", userM.getIdUser());
        info.put("userName", userM.getUsername());
        List<String> role = new ArrayList<>();
        role.add(userM.getRole());
        info.put("role", role);
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}