package bean;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String id;
	private String pass;
	private String mail;
	
	public Account() {}
	
	public Account(String name, String id, String pass, String mail) {
		super();
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.mail = mail;
	}




	//get & set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

	
}
