package org.terasoluna.tourreservation.app.login;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TodoRestController {

    // omitted

    @RequestMapping(value = "todos", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
//    public Collection<Todo> list(OAuth2Authentication authentication) {
    public Collection list(OAuth2Authentication authentication) {

        String username = authentication.getUserAuthentication().getName();
        String clientId = authentication.getOAuth2Request().getClientId();

        System.out.println("TodoRestController=========> username " + username);
        System.out.println("TodoRestController=========> clientId " + clientId);
        return null;

    }
}