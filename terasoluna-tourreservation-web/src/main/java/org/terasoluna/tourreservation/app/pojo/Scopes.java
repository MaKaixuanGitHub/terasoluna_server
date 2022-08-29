package org.terasoluna.tourreservation.app.pojo;

import java.io.Serializable;

public class Scopes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String clientId;
	
	private String scope;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	
}
