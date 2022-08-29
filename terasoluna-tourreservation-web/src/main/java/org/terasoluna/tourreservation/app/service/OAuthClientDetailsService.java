package org.terasoluna.tourreservation.app.service;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.tourreservation.app.pojo.Client;
import org.terasoluna.tourreservation.app.pojo.OAuthClientDetails;
import org.terasoluna.tourreservation.app.repository.ClientRepository;

@Service("clientDetailsService")
@Transactional
public class OAuthClientDetailsService implements ClientDetailsService {
       @Inject
       ClientRepository clientRepository;

       @Override
       public ClientDetails loadClientByClientId(String clientId)
                throws ClientRegistrationException {
            // DBからクライアント情報を取得する
            Client client = clientRepository.findClientByClientId(clientId);

            // クライアント情報が見つからない場合は、Spring Security OAuthの例外である
            if (client == null) {
                  throw new NoSuchClientException("No client with requested id: " + clientId);
            }

            // クライアントに紐付く情報を取得する
            Set<String> clientScopes = clientRepository.findClientScopesByClientId(clientId);
            Set<String> clientResources = clientRepository.findClientResourcesByClientId(clientId);
            Set<String> clientGrants = clientRepository.findClientGrantsByClientId(clientId);
            Set<String> clientRedirectUris = clientRepository.findClientRedirectUrisByClientId(clientId);

            // 取得した各種情報をOAuthClientDetailsのフィールドに設定する
            OAuthClientDetails clientDetails = new OAuthClientDetails();
            clientDetails.setClientId(client.getClientId());
            clientDetails.setClientSecret(client.getClientSecret());
            clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
            clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());
            clientDetails.setResourceIds(clientResources);
            clientDetails.setScope(clientScopes);
            clientDetails.setAuthorizedGrantTypes(clientGrants);
            clientDetails.setRegisteredRedirectUri(clientRedirectUris);
            clientDetails.setClient(client);

            return clientDetails;
        }
}
