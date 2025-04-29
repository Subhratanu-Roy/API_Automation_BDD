package resources;

public enum APIResources {

	AddUserAPI("/api/users"),
	GetUserAPI("/api/users/2"),
	DeleteUserAPI("/api/users/2"),
	LoginUserAPI("/api/login"),
	RegisterUserAPI("/api/register");
	String resource;
	
	APIResources(String resource){
		this.resource = resource;
	}
	public String getResource() {
		return resource;
	}
	
}
