package silly.servlet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import silly.domain.User;
import silly.utils.HibernateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        test();
        response.getWriter().println("success");
    }

    @Test
    public void test() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------
        User user = new User("101","lisi","123123","万物","lisi@163.com",
                "110","1996-12-30","male",0,"qazwx2123");
        session.save(user);
        //----------------------------------------------
        tx.commit();
        session.close();
    }

}
