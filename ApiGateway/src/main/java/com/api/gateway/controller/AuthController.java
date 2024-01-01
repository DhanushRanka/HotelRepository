package com.api.gateway.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gateway.models.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
//	@Autowired
//	OidcUser user;
	
	@GetMapping("/test")
	public String test()
	{
		return "testing";
	}
	
	
	@GetMapping("/login")
	public AuthResponse login(
			@org.springframework.security.core.annotation.AuthenticationPrincipal OidcUser user,
			@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client
		)
	{
		
		System.out.println(client);
		String as=client.getAccessToken().getTokenValue();
		
		String email=null;
		
		if(user!=null)
			email = user.getEmail();
//		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		
		List<String>authorities=user.getAuthorities().stream()
		.map(grantAuth->grantAuth.getAuthority())
		.collect(Collectors.toList());
		
		OAuth2AccessToken accessToken = client.getAccessToken();
		OAuth2RefreshToken refreshToken = client.getRefreshToken();
		
		
		AuthResponse authResponse=new AuthResponse();
		authResponse.setUserId(email);
		authResponse.setAccessToken(accessToken.getTokenValue());
		authResponse.setRefereshToken(refreshToken.getTokenValue());
		authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
		authResponse.setAuthorities(authorities);
		
		return authResponse;
	}
	
}
