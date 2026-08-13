package MYPACKAGE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class student 
{
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int S_ID ;

	@Column(name="S_FNAME")
	private String S_FNAME;
	
	@Column(name="S_LNAME")
	private String S_LNAME;
	
	@Column(name="S_MAILID")
	private String S_MAILID;
	
	
	@Column(name="S_PHNM")
	private String S_PHNM;
	
	@Column(name="S_ADDRESS")
	private String S_ADDRESS;
	
	@Column(name="S_COURSE")
	private String S_COURSE;
	
	
	public int getS_ID() {
		return S_ID;
	}

	public void setS_ID(int s_ID) {
		S_ID = s_ID;
	}

	public String getS_FNAME() {
		return S_FNAME;
	}

	public void setS_FNAME(String s_FNAME) {
		S_FNAME = s_FNAME;
	}

	public String getS_LNAME() {
		return S_LNAME;
	}

	public void setS_LNAME(String s_LNAME) {
		S_LNAME = s_LNAME;
	}

	public String getS_MAILID() {
		return S_MAILID;
	}

	public void setS_MAILID(String s_MAILID) {
		S_MAILID = s_MAILID;
	}

	public String getS_PHNM() {
		return S_PHNM;
	}

	public void setS_PHNM(String s_PHNM) {
		S_PHNM = s_PHNM;
	}

	public String getS_ADDRESS() {
		return S_ADDRESS;
	}

	public void setS_ADDRESS(String s_ADDRESS) {
		S_ADDRESS = s_ADDRESS;
	}

	public String getS_COURSE() {
		return S_COURSE;
	}

	public void setS_COURSE(String s_COURSE) {
		S_COURSE = s_COURSE;
	}

	
}
	

	
	