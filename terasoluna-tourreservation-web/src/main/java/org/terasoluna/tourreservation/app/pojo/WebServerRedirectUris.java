package org.terasoluna.tourreservation.app.pojo;

import java.io.Serializable;

public class WebServerRedirectUris implements Serializable{

	private static final long serialVersionUID = 1L;

	private String clientId;
	
	private String webServerRedirectUri;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}
	
	
}
