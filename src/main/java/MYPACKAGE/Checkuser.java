package MYPACKAGE;

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


public class Checkuser extends HttpServlet {
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
	

  Query qry =S.createQuery("from user u where u.mail_id=:VAL"); // named parameter
 
  qry.setParameter("VAL", request.getParameter("email"));
  
	List L = qry.list();
	
	Iterator it = L.iterator();
	while(it.hasNext())
		{
		user u = (user)it.next();
		flag = 1;	
		break;
		}

	if(flag == 1)
	{
		rs = request.getServletContext().getRequestDispatcher("/main.jsp");
		 
			
						
	}
	else
	{
		rs = request.getServletContext().getRequestDispatcher("/student.jsp");		
	}
	
	
	rs.forward(request, response);
	  	
	S.close();
	//F.close();
	}

	
}
