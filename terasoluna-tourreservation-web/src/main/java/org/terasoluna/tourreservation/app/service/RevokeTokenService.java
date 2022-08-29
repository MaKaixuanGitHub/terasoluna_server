package org.terasoluna.tourreservation.app.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface RevokeTokenService {
	ResponseEntity<Map<String,String>> revokeToken(String tokenValue, String clientId);
}
