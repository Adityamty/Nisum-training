import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final String VALID_USER = "NisumSupport"
    private static final String VALID_PASS = "LetMeIn@2025";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (VALID_USER.equals(username) && VALID_PASS.equals(password)) {
            out.println("<h2>Login Successful!</h2>");
          
            String externalURL = "https://www.nisum.com"; 
            response.sendRedirect(externalURL);

        } else {
            out.println("<h2>Login Failed.</h2>");
            out.println("<p>Invalid username or password.</p>");
        }

        out.println("</body></html>");
    }
}
