package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import MYPACKAGE.parent;
import MYPACKAGE.student;

public class parent1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("mailid");
        String password = request.getParameter("password");
        if (isBlank(email) || isBlank(password)) {
            request.setAttribute("error", "Enter your email and password.");
            request.getRequestDispatcher("parent.jsp").forward(request, response);
            return;
        }

        Session session = new Configuration().configure("connect.cfg.xml")
                .buildSessionFactory().openSession();
        Query query = session.createQuery(
                "from parent p where p.mail_id=:EMAIL and p.password=:PASSWORD");
        query.setParameter("EMAIL", email.trim());
        query.setParameter("PASSWORD", password);
        List accounts = query.list();
        if (!accounts.isEmpty()) {
            parent account = (parent) accounts.get(0);
            HttpSession webSession = request.getSession(true);
            webSession.setAttribute("email", account.getMail_id());
            webSession.setAttribute("role", "parent");
            webSession.setAttribute("studentEmail", account.getStudent_mail_id());
            Query studentQuery = session.createQuery("from student s where s.S_MAILID=:EMAIL");
            studentQuery.setParameter("EMAIL", account.getStudent_mail_id());
            List students = studentQuery.list();
            if (!students.isEmpty()) {
                student linkedStudent = (student) students.get(0);
                webSession.setAttribute("studentName", linkedStudent.getS_FNAME() + " " + linkedStudent.getS_LNAME());
                webSession.setAttribute("studentCourse", linkedStudent.getS_COURSE());
            }
            session.close();
            request.getRequestDispatcher("parent-dashboard.jsp").forward(request, response);
            return;
        }

        session.close();
        request.setAttribute("error", "Email or password is incorrect.");
        request.getRequestDispatcher("parent.jsp").forward(request, response);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
