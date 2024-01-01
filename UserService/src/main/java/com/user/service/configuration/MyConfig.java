package com.user.service.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.JwtBearerOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.okta.spring.boot.oauth.http.Auth0ClientRequestInterceptor;
import com.user.service.configuration.interceptor.RestTemplateInterceptor;

@Configuration
public class MyConfig {

	@Autowired
	ClientRegistrationRepository clientRegistrationReository;
	
	@Autowired
	OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		RestTemplate restTemplate=new RestTemplate();
		
		List<ClientHttpRequestInterceptor>interceptor=new ArrayList<>();
		interceptor.add(new RestTemplateInterceptor(manager(
				clientRegistrationReository,oAuth2AuthorizedClientRepository
		)));
		
		
		restTemplate.setInterceptors(interceptor);
		
		
		return restTemplate ;
	}
	
	@Bean
	public OAuth2AuthorizedClientManager manager(
	ClientRegistrationRepository clientRegistrationReository,
	OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository
	)
	{
		DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager=new DefaultOAuth2AuthorizedClientManager(clientRegistrationReository,oAuth2AuthorizedClientRepository);
		 
		OAuth2AuthorizedClientProvider provider=OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
		
		
		defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);
		
		
		return defaultOAuth2AuthorizedClientManager;
	}

}
