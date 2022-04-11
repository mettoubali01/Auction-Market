package com.example.auctions_web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class CustomOAuthUser implements OAuth2User {

    private OAuth2User oAuth2User;

    public CustomOAuthUser(OAuth2User oAuth2User) {
        this.oAuth2User = oAuth2User;

        System.out.println(" AA  " + getEmail());
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oAuth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return oAuth2User.getAttribute("name");
    }


    public String getEmail() {
        System.out.println(oAuth2User.getAttributes());
        return oAuth2User.<String>getAttribute("email");

    }

    public String getFamilyName() {
        return oAuth2User.<String>getAttribute("family_name");
    }
}
