package MYPACKAGE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact 
{
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int S_ID;
	
	@Column(name="Firstname")
	private String Firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="country")
	private String country;
	
	@Column(name="subject")
	private String subject;

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
