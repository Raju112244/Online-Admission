package MYPACKAGE;

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

public class Checkuser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (isBlank(email) || isBlank(password)) {
            request.setAttribute("error", "Enter your email and password.");
            request.getRequestDispatcher("student.jsp").forward(request, response);
            return;
        }

        Session session = new Configuration().configure("connect.cfg.xml")
                .buildSessionFactory().openSession();
        Query query = session.createQuery(
                "from user u where u.mail_id=:EMAIL and u.password=:PASSWORD");
        query.setParameter("EMAIL", email.trim());
        query.setParameter("PASSWORD", password);
        List accounts = query.list();

        if (!accounts.isEmpty()) {
            user account = (user) accounts.get(0);
            HttpSession webSession = request.getSession(true);
            webSession.setAttribute("email", account.getMailid());
            webSession.setAttribute("role", "student");
            session.close();
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        }

        session.close();
        request.setAttribute("error", "Email or password is incorrect.");
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
