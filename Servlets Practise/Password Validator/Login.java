import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

public class Login extends HttpServlet {
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException {
        String uname = req.getParameter("userName");
        String pass = req.getParameter("userPass");

        // res.sendRedirect("welcome.jsp");
        if ( uname.equals("hlajsf") )
            System.out.print("safdaf");
        else
            System.out.print("Hello World");
        }
    }
