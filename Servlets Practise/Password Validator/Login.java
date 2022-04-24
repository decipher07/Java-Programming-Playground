import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String uname = req.getParameter("userName");
        String pass = req.getParameter("userPass");

        if ( pass.equals("servlet") ){
            RequestDispatcher rd = req.getRequestDispatcher("servlet2");
            rd.forward(req, res);
        } else {
            out.println("Sorry UserName or Passsword Error!");
            RequestDispatcher rd = req.getRequestDispatcher("servlet1");
            rd.include(req, res);
        }

    }
}
