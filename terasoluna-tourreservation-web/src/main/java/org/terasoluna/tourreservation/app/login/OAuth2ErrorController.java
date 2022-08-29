package org.terasoluna.tourreservation.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OAuth2ErrorController {

    @RequestMapping("/oauth/error")
    public String handleError() {
        System.out.println("OAuth2ErrorController============>handleError");
        return "common/error/oauthError";
    }
}
