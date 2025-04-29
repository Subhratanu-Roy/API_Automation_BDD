package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@AddUserAPI")
	public void beforeAddUser() {
		System.out.println("**********Exeuting add user API**********");
	}

	@Before("@GetUserAPI")
	public void beforeGetUser() {
		System.out.println("**********Exeuting get user API**********");
	}

	@Before("@LoginUserAPI")
	public void beforeLoginUser() {
		System.out.println("**********Exeuting login user API**********");
	}

	@Before("@RegisterUserAPI")
	public void beforeRegisterUser() {
		System.out.println("**********Exeuting register user API**********");
	}

}
