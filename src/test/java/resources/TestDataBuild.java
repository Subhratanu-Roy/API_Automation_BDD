package resources;

import pojo.Login;
import pojo.User;

public class TestDataBuild {

	public static User addUserPayload(String name, String job) {
		User user = new User();
		user.setName(name);
		user.setJob(job);
		return user;
	}
	
	public static Login loginPayload(String email, String password) {
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		return login;
	}
}
