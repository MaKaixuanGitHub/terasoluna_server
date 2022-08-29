package org.terasoluna.tourreservation.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OAuth2ApprovalController {
	@RequestMapping("/oauth/confirm_access")
	public String confirmAccess() {
		System.out.println("OAuth2ApprovalController============>confirmAccess");
		return "approval/oauthConfirm";
	}
}
