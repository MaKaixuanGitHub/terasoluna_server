package org.terasoluna.tourreservation.app.pojo;

import java.io.Serializable;

public class AuthorizedGrantTypes implements Serializable{

	private static final long serialVersionUID = 1L;

	private String clientId;
	
	private String authorizedGrantType;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAuthorizedGrantType() {
		return authorizedGrantType;
	}

	public void setAuthorizedGrantType(String authorizedGrantType) {
		this.authorizedGrantType = authorizedGrantType;
	}
	
	
}
