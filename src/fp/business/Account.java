package fp.business;

import java.io.Serializable;

public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String email;
	private String username;
	private String password;
	private boolean isAdmin;
	
	public Account() {};
	public Account(String id, String email, String username, String password, String code, boolean isAdmin) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.code = code;
		this.isAdmin = isAdmin;
		this.username = username;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public String getCode() {
		return code;
	}
}