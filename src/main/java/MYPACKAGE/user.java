package MYPACKAGE;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class user 
{
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name="mail_id")
	private String mail_id;

	@Column(name="password")
	private String password;
	
	@Column(name="user")
	private String user;
	

	
	public String getMailid() {
		return mail_id;
	}



	public void setMailid(String mailid) {
		this.mail_id = mailid;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String toString()
	{
		return getMailid()+" exists";
	}
			
	
	
}

	
