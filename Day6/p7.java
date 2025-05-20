import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextParamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        ServletContext context = getServletContext();

    
        String company = context.getInitParameter("companyName");
        String support = context.getInitParameter("supportEmail");

  
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        
        out.println("<html><body>");
        out.println("<h2>Context Parameters</h2>");
        out.println("<p>Company Name: " + company + "</p>");
        out.println("<p>Support Email: " + support + "</p>");
        out.println("</body></html>");
    }
}
