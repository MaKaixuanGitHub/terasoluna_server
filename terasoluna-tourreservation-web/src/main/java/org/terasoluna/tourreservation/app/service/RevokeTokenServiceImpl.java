package org.terasoluna.tourreservation.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.approval.Approval;
import org.springframework.security.oauth2.provider.approval.Approval.ApprovalStatus;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.date.jodatime.JodaTimeDateFactory;

@Service
@Transactional
public class RevokeTokenServiceImpl implements RevokeTokenService {

    // アクセストークンの取り消しを行う
    @Inject
    ConsumerTokenServices consumerService;

    //アクセストークン発行時の認証情報を取得するために使用する
    @Inject
    TokenStore tokenStore;

    //アクセストークンの発行時の認可情報を取得するために使用する
    @Inject
    ApprovalStore approvalStore;

    @Inject
    JodaTimeDateFactory dateFactory;

    /***
     * 取り消しを行うアクセストークンの値と、
     * クライアントのチェックを行うために使用するクライアントIDをパラメータとして受け取る
     */
    public ResponseEntity<Map<String, String>> revokeToken(String tokenValue, String clientId){ // (4)
   
        // TokenStoreのreadAuthenticationメソッドを呼び出し、アクセストークンを発行した際の認証情報を取得する
        // 認証情報が正常に取得できた場合のみ、トークンの削除処理を行う。
        OAuth2Authentication authentication = tokenStore.readAuthentication(tokenValue);

        Map<String,String> map = new HashMap<>();

        if (authentication != null) {
            // 認証情報より、アクセストークン発行時に使用したクライアントIDを取得し、リクエストパラメータのクライアントIDと一致するかを確認する。
            // アクセストークン発行時のクライアントIDと一致する場合のみ、アクセストークンの削除を行う。
            if (clientId.equals(authentication.getOAuth2Request().getClientId())) {
                // 認証情報より、アクセストークン発行時のリソースオーナの認証情報を取得する。
                Authentication user = authentication.getUserAuthentication();
                if (user != null) {
                    Collection<Approval> approvals = new ArrayList<>();
                    for (String scope : authentication.getOAuth2Request().getScope()) {
                        approvals.add(
                                new Approval(user.getName(), clientId, scope, dateFactory.newDate(), ApprovalStatus.APPROVED));
                    }
                    approvalStore.revokeApprovals(approvals);
                }
                // ConsumerTokenServiceのrevokeTokenメソッドを呼び出し、アクセストークンとアクセストークンに紐付くリフレッシュトークンの削除を行う。
                consumerService.revokeToken(tokenValue);
                return ResponseEntity.ok().body(map);

            } else {
                map.put("error", "invalid_client");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
            }
        } else {
            map.put("error", "invalid_request");
            return ResponseEntity.badRequest().body(map);
        }
    }
}