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

import MYPACKAGE.admin;

public class admin1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("mailid");
        String password = request.getParameter("password");
        if (isBlank(email) || isBlank(password)) {
            request.setAttribute("error", "Enter your administrator email and password.");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
            return;
        }

        Session session = new Configuration().configure("connect.cfg.xml")
                .buildSessionFactory().openSession();
        Query query = session.createQuery(
                "from admin a where a.mail_id=:EMAIL and a.password=:PASSWORD");
        query.setParameter("EMAIL", email.trim());
        query.setParameter("PASSWORD", password);
        List accounts = query.list();

        if (!accounts.isEmpty()) {
            HttpSession webSession = request.getSession(true);
            webSession.setAttribute("email", email.trim());
            webSession.setAttribute("role", "admin");
            session.close();
            request.getRequestDispatcher("admin-dashboard.jsp").forward(request, response);
            return;
        }

        session.close();
        request.setAttribute("error", "Administrator email or password is incorrect.");
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
