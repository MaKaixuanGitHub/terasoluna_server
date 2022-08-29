package org.terasoluna.tourreservation.app.login;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.terasoluna.tourreservation.app.service.RevokeTokenService;

/***
 * トークンの取り消しリクエストを受けるコントローラを作成する。
 * @author YangWenzhuo
 *
 */
@RestController
@RequestMapping("oauth")
public class TokenRevocationRestController {

    @Inject
    RevokeTokenService revokeTokenService;

    /***
     * @RequestMappingアノテーションを使用して、/oauth/tokens/revokeへのアクセスに対するメソッドとしてマッピングを行う。
     * ここで指定するパスはクライアントの認証で行った設定と同様に、Basic認証の適用とCSRF対策機能の無効化を行う必要がある。
     */
    @RequestMapping(value = "tokens/revoke", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> revoke(@RequestParam("token") String tokenValue,
        @AuthenticationPrincipal UserDetails user){

        // Basic認証で生成された認証情報からトークンの取り消し時のチェックで使用するクライアントIDを取得する。
        String clientId = user.getUsername();

        // RevokeTokenServiceを呼び出し、トークンの取り消しを行う。
        // リクエストパラメータとして受け取ったアクセストークンの値と、認証情報から取得したクライアントIDをパラメータとして渡す。
        ResponseEntity<Map<String,String>> result = revokeTokenService.revokeToken(tokenValue, clientId);
        return result;
    }
}