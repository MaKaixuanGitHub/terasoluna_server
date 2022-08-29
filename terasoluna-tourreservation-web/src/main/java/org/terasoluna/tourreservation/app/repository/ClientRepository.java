package org.terasoluna.tourreservation.app.repository;

import java.util.Set;

import org.terasoluna.tourreservation.app.pojo.Client;

public interface ClientRepository{
    /**
     * findClientByClientId
     * @param clientId clientId
     */
    Client findClientByClientId(String clientId);

    /**
     * findClientScopesByClientId
     * @param clientId clientId
     */
    Set<String> findClientScopesByClientId(String clientId);

    /**
     * findClientResourcesByClientId
     * @param clientId clientId
     */
    Set<String> findClientResourcesByClientId(String clientId);

    /**
     * findClientGrantsByClientId
     * @param clientId clientId
     */
    Set<String> findClientGrantsByClientId(String clientId);

    /**
     * findClientRedirectUrisByClientId
     * @param clientId clientId
     */
    Set<String> findClientRedirectUrisByClientId(String clientId);

}
