package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import MYPACKAGE.parent;

public class ParentSignup extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("parent_name");
        String email = request.getParameter("parent_email");
        String studentEmail = request.getParameter("student_email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm_password");
        if (isBlank(name) || isBlank(email) || isBlank(studentEmail) || isBlank(password)
                || !password.equals(confirm)) {
            request.setAttribute("error", "Complete all fields and enter matching passwords.");
            request.getRequestDispatcher("parent-register.jsp").forward(request, response);
            return;
        }

        Session session = new Configuration().configure("connect.cfg.xml")
                .buildSessionFactory().openSession();
        session.getTransaction().begin();
        Query existing = session.createQuery("from parent p where p.mail_id=:EMAIL");
        existing.setParameter("EMAIL", email.trim());
        if (!existing.list().isEmpty()) {
            session.getTransaction().rollback();
            session.close();
            request.setAttribute("error", "A parent account already exists for this email.");
            request.getRequestDispatcher("parent-register.jsp").forward(request, response);
            return;
        }

        parent account = new parent();
        account.setP_name(name.trim());
        account.setMail_id(email.trim());
        account.setStudent_mail_id(studentEmail.trim());
        account.setPassword(password);
        session.save(account);
        session.getTransaction().commit();
        session.close();
        response.sendRedirect("parent.jsp?registered=true");
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
