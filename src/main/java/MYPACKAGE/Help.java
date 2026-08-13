package MYPACKAGE;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class Help extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
RequestDispatcher rs;
		
		Configuration cfg = new Configuration();
		Session S = cfg.configure("connect.cfg.xml").buildSessionFactory().openSession();
		
		S.getTransaction().begin();
		
		
		String Fname = request.getParameter("firstname");
		String Lname = request.getParameter("lastname");
		String country    = request.getParameter("country");
		String subject = request.getParameter("subject");
		
		/********************  UPLOADING A IMAGES      ******************************************/
		System.out.println(Fname);
		System.out.println(Lname);
		System.out.println(country);
		System.out.println(subject);
		
		Contact c = new Contact();
		c.setFirstname(Fname);
		c.setLastname(Lname);
		c.setCountry(country);
		c.setSubject(subject);
			
		
		S.save(c);
		S.getTransaction().commit();
		
		S.close();
		
		System.out.println("Adding Sucessfully");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	

		
	}
 
 
 
 
 
	}

	



