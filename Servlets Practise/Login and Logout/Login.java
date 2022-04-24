import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("userName");
        String pass = request.getParameter("userPass");

        Cookie ck = new Cookie("uname", uname);
        response.addCookie(ck);

        RequestDispatcher rd =  request.getRequestDispatcher("servlet2");
        rd.forward(request, response);
    }
}
