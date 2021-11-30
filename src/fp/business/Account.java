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
	private String phone;
	private String address;
	private boolean isAdmin;
	
	public Account() {};
	public Account(String id, String email, String username, String password, 
			String code, String phone, String address, boolean isAdmin) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.code = code;
		this.isAdmin = isAdmin;
		this.username = username;
		this.phone = phone;
		this.address = address;
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
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
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
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public String getCode() {
		return code;
	}
}