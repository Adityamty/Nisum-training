import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        ServletConfig config = getServletConfig();

        
        String adminName = config.getInitParameter("adminName");
        String adminEmail = config.getInitParameter("adminEmail");

      
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        
        out.println("<html><body>");
        out.println("<h2>Initialization Parameters</h2>");
        out.println("<p>Admin Name: " + adminName + "</p>");
        out.println("<p>Admin Email: " + adminEmail + "</p>");
        out.println("</body></html>");
    }
}
