package org.terasoluna.tourreservation.app.pojo;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class OAuthClientDetails extends BaseClientDetails{
    /**クライアントの詳細情報 */
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
