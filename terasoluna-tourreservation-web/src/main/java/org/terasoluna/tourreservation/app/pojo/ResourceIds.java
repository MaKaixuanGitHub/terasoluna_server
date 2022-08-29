package org.terasoluna.tourreservation.app.pojo;

import java.io.Serializable;

public class ResourceIds implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String clientId;
	
	private String recourceId;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRecourceId() {
		return recourceId;
	}

	public void setRecourceId(String recourceId) {
		this.recourceId = recourceId;
	}
	

}
