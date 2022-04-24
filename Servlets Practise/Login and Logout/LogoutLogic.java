import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutLogic extends HttpServlet {
    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws  ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie ck = new Cookie("uname", "");
        ck.setMaxAge(0);

        

        Cookie cks[] = request.getCookies();
        out.println("Hello SUCCESSFUL" + cks[0].getValue() + " " + cks[0].getName() );

    }
}
