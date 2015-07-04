package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;

import SnippingCode.Domain.Code;
import SnippingCode.Domain.User;
import SnippingCode.JsonParser.ParseJsonObject;
import SnippingCode.ObjectRequest.CodeReq;
import SnippingCode.Service.CodesHttpRequest;
import SnippingCode.Service.FileOperation;
import SnippingCode.Service.UserHttpRequest;
import service.UserService;

public class LoginController {

	private LoginModel model;
	private LoginView view;
	private UserService userService;
	private CodesHttpRequest codesHttpRequest;
	private UserHttpRequest userHttpRequest;
	private String username;
	private String password;
	private FileOperation fileOperation;

	public LoginController(LoginModel model, LoginView view) {
		this.model = model;
		this.view = view;
		this.userService = new UserService();
		this.view.setLoginButtonAction(new LoginButtonAction());
		this.view.setUsernameFieldAction(new PreventSpacesInJTextFieldAction());
		this.view.setPasswordFieldAction(new PreventSpacesInJTextFieldAction());
		userHttpRequest = new UserHttpRequest();
		codesHttpRequest = new CodesHttpRequest();
		fileOperation = new FileOperation();
	}

	private void getUserCode() {

		try {
			ArrayList<Code> codes = codesHttpRequest.getAllCode(username,
					password, "0");
			fileOperation.initXmlFile(codes);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		List<Code> codes = fileOperation.parseXmlFile();
		ArrayList<Code> codesArray = new ArrayList<Code>();

		// get from server
		for (Code item : codes) {
			CodeReq codeReq = new CodeReq(item, username, password);
			try {
				codesArray.add(codesHttpRequest.getCodeByName(codeReq)); // return
																			// codeDomainParser
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (Code code : codesArray) {
			fileOperation.saveCodeToFile(code);
		}

	}

	class LoginButtonAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			username = view.getUsername();
			password = view.getPassword();
			model.setUsername(username);
			model.setPassword(password);
			try {
				int statusCode = model.tryToLogin();
				switch (statusCode) {
				case 1:
					view.errorMessage("some fields are missed");
					break;
				case 2:
					view.errorMessage("you ar");
					break;
				case HttpURLConnection.HTTP_OK:
					userService.saveUser(username, password);
					getUserCode();
					view.errorMessage("Done");
					view.dispose();
					break;
				case HttpURLConnection.HTTP_NOT_FOUND:
					view.errorMessage("invalid usename or password");
					break;
				default:
					break;
				}
			} catch (IOException e1) {
				view.errorMessage("the server is down");
			}
		}

	}

	class PreventSpacesInJTextFieldAction implements KeyListener {

		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_SPACE)
				e.consume();
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}
	}

	public void setVisible(boolean key) {
		view.setVisible(key);
	}

	public HashMap<String, String> getUser() {
		return userService.getUser();
	}

}
