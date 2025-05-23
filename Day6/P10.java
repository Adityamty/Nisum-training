import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHeaderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Request Headers:</h2>");
        out.println("<table border='1'><tr><th>Header Name</th><th>Header Value</th></tr>");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<tr><td>" + headerName + "</td><td>" + headerValue + "</td></tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
