package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import MYPACKAGE.parent;


public class parent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int flag=0;
		 RequestDispatcher rs;
	
	//response.setContentType("text/html");
	//PrintWriter pw = response.getWriter();
	

	/* Configuration cfg = new Configuration();
	 cfg.configure("connect.cfg.xml");	 	
	 SessionFactory F = cfg.buildSessionFactory();     
	 Session S = F.openSession();
	 */
	
	Configuration cfg = new Configuration();	  
	Session S = cfg.configure("connect.cfg.xml").buildSessionFactory().openSession();
	String Fname = request.getParameter("mailid");
	String Lname = request.getParameter("password");

 Query qry =S.createQuery("from parent u where u.mail_id=:VAL"); // named parameter

 qry.setParameter("VAL", Fname);
 
	List L = qry.list();
	parent u= null;
	Iterator it = L.iterator();
	while(it.hasNext())
		{
		 u = (parent)it.next();
		flag = 1;	
		break;
		}
        
	if(flag == 1 && u.getPassword().equals(Lname))
	{
		rs = request.getServletContext().getRequestDispatcher("/main.jsp");
		 
			
						
	}
	else
	{
		rs = request.getServletContext().getRequestDispatcher("/parent.jsp");		
	}
	
	
	rs.forward(request, response);
	  	
	S.close();
	//F.close();
	}

	

	}

	