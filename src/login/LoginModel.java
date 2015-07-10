package login;

import java.io.IOException;

import service.UserService;

//import com.sun.xml.internal.ws.wsdl.writer.document.Service;

import SnippingCode.Domain.User;
import SnippingCode.Service.UserHttpRequest;

public class LoginModel {

	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int tryToLogin() throws IOException {
		if (this.username.equals(""))
			return 1;
		if (this.password.equals(""))
			return 1;

		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);

		UserHttpRequest request = new UserHttpRequest(user);
		return request.login();
	}
}
