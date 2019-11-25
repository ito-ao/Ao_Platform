package model;

public class Login {

	private int id;
	private static String name;
	private static String pass;

	public Login(String name,String pass) {
		this.name = name;
		this.pass = pass;
	}
	public static Login getInstance() {
		return new Login(name,pass);
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}

	public int getId() {
		return id;
	}

}
