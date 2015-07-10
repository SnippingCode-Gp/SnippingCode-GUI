package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import SnippingCode.Domain.User;

//import com.sun.javafx.collections.MappingChange.Map;

public class UserService {

	private String executeCommand(String command) {

		Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				return line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	public boolean saveUser(String username, String password) {
		JSONObject object = new JSONObject();
		try {
			object.put("username", username);
			object.put("password", password);
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
		PrintWriter out = null;
		File file = new File("/home/" + executeCommand("whoami") + "/.SC/user");

		try {
			out = new PrintWriter(file);
			out.println(object.toString());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean checkUser(String username, String password) {
		JSONObject object = null;

		BufferedReader rd = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("/home/" + executeCommand("whoami")
					+ "/.SC/user");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		try {
			rd = new BufferedReader(fileReader);
			String line;
			while ((line = rd.readLine()) != null) {
				object = new JSONObject(line);
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}

		try {
			if (username.equals(object.get("username"))
					&& password.equals(object.get("password")))
				return true;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	public HashMap<String, String> getUser() {
		JSONObject object = null;

		BufferedReader rd = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("/home/" + executeCommand("whoami")
					+ "/.SC/user");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		try {
			rd = new BufferedReader(fileReader);
			String line;
			while ((line = rd.readLine()) != null) {
				object = new JSONObject(line);
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		HashMap<String, String> mp = new HashMap<String, String>();
		try {
			mp.put("username", object.getString("username"));
			mp.put("password", object.getString("password"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mp;
	}
}
