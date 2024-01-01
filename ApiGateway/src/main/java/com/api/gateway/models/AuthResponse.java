package com.api.gateway.models;

import java.util.Collection;

public class AuthResponse {

	private String userId;
	
	private String accessToken;
	
	private String refereshToken;
	
	private long expireAt;
	
	private Collection<String>authorities;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefereshToken() {
		return refereshToken;
	}

	public void setRefereshToken(String refereshToken) {
		this.refereshToken = refereshToken;
	}

	public long getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(long expireAt) {
		this.expireAt = expireAt;
	}

	public Collection<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<String> authorities) {
		this.authorities = authorities;
	}

	public AuthResponse(String userId, String accessToken, String refereshToken, long expireAt,
			Collection<String> authorities) {
		super();
		this.userId = userId;
		this.accessToken = accessToken;
		this.refereshToken = refereshToken;
		this.expireAt = expireAt;
		this.authorities = authorities;
	}

	public AuthResponse() {
		super();
	}
	
	
}
