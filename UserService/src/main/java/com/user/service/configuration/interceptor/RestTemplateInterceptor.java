package com.user.service.configuration.interceptor;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

	private OAuth2AuthorizedClientManager manager;		
	
	public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager)
	{
		this.manager=manager;	
	}
		
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		OAuth2AuthorizedClient authorize = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build());
		String token = authorize.getAccessToken().getTokenValue();
		
		HttpHeaders headers = request.getHeaders();
		headers.add("Authorization", "Bearer "+token);
		
		return execution.execute(request,body);
	}

}
