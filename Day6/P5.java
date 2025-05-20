import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET request to set and read cookies
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        
        Cookie userCookie = new Cookie("username", "JohnDoe");
        userCookie.setMaxAge(60 * 60); 
        response.addCookie(userCookie);

        out.println("<html><body>");
        out.println("<h2>Cookie has been set!</h2>");

        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            out.println("<h3>Reading Cookies:</h3>");
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + ": " + c.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("</body></html>");
    }
}
