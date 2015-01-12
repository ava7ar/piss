package bg.fmi.unisofia.piss.appframework.core;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UserAccount implements Persistable {
	
	@Column(name="name")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Id
	private String id;
	
	public UserAccount() {
		//DO NOT USE - Hibernate
	}

	public void setUsername(String name) {
		username = name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String pass) {
		password = pass;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String mail) {
		email = mail;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId() {
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
}
