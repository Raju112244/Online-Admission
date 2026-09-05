package MYPACKAGE;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;


@MultipartConfig(
		location="C:\\Users\\Raju\\Downloads\\spring-tool-suite-3.9.11.RELEASE-e4.14.0-win32-x86_64\\sts-bundle\\sts-3.9.11.RELEASE\\sts\\ONLINE_ADMISSION\\src\\main\\webapp\\images",
		fileSizeThreshold = 1024 * 1024 ,// 1mb
		maxFileSize=1024 * 1024 * 10 ,//10mb
		maxRequestSize = 1024 * 1024 * 11 // 11 mb
		)
public class signup extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	
   
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String email = request.getParameter("Email_Id");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");
		if (isBlank(email) || isBlank(password) || !password.equals(confirmPassword)) {
			request.setAttribute("error", "Enter an email and matching passwords.");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}

		Configuration cfg = new Configuration();
		Session S = cfg.configure("connect.cfg.xml").buildSessionFactory().openSession();
		S.getTransaction().begin();
		Query existing = S.createQuery("from user u where u.mail_id=:VAL");
		existing.setParameter("VAL", email.trim());
		if (!existing.list().isEmpty()) {
			S.getTransaction().rollback();
			S.close();
			request.setAttribute("error", "An account already exists for this email.");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}

		String Fname = request.getParameter("First_Name");
		String Lname = request.getParameter("Last_Name");
		String MAILID    = email.trim();
		String PHNM = request.getParameter("Mobile_Number");
		String ADDRESS = request.getParameter("Address");
		String COURSE = request.getParameter("Course_BCA");
		String  pic=null ;
		String meg=null;
		/********************  UPLOADING A IMAGES      ******************************************/
		System.out.println(Fname);
		System.out.println(Lname);
		System.out.println(MAILID);
		System.out.println(PHNM);
		System.out.println(ADDRESS);
		System.out.println(COURSE);
		try {
			Part part = request.getPart("pic");  // 
			part.write(filename(part));
			
			meg = "file upload succes";
			pic= filename(part);
			System.out.println(meg);
		}
		catch(Exception e)
		
		{
			meg = "file upload failure" + e.getMessage();
			System.out.println(meg);
		}
		student u = new student();
		u.setS_FNAME(Fname);
		u.setS_LNAME(Lname);
		u.setS_MAILID(MAILID);
		u.setS_PHNM(PHNM);
		u.setS_ADDRESS(ADDRESS);
		u.setS_COURSE(COURSE);
		S.save(u);

		user account = new user();
		account.setMailid(MAILID);
		account.setPassword(password);
		account.setUser("student");
		S.save(account);
	
		
		S.getTransaction().commit();
		
		S.close();
		
		System.out.println("Adding Sucessfully");
		
		request.getRequestDispatcher("student.jsp?registered=true").forward(request, response);
	

		
	}
 private String filename(Part part) {
	 String disposition=part.getHeader("content-disposition");
	 if(!disposition.contains("filename=")) {
		 return null;
	 }
	 int beginIndex = disposition.indexOf("filename=") + 10;
	 int lastIndex = disposition.length()-1;
	 
	 return disposition.substring(beginIndex, lastIndex);
	 
 }
	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

}
