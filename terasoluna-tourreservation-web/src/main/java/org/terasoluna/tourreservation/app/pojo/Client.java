package org.terasoluna.tourreservation.app.pojo;

import java.io.Serializable;

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    /** クライアント識別するクライアントID */
    private String clientId;

    /** クライアント認証に使用するパスワード */
    private String clientSecret;

    /** クライアント名を保持する拡張フィールド */
    private String clientName;

    /** アクセストークンの有効期間[秒] */
    private Integer accessTokenValidity;

    /** リフレッシュトークンの有効期間[秒] */
    private Integer refreshTokenValidity;
    
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getClientSecret() {
        return clientSecret;
    }
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }
}
