import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitTrackerServlet")
public class VisitTrackerServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int visitCount = 0;
        
        // 1. Retrieve all cookies from the incoming request
        Cookie[] cookies = request.getCookies();
        
        // 2. Search for our specific "user_visit_count" cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user_visit_count".equals(cookie.getName())) {
                    visitCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        
        // 3. Increment the counter for this visit
        visitCount++;
        
        // 4. Create or update the cookie to send back to the browser
        Cookie visitCookie = new Cookie("user_visit_count", String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24 * 7); // Cookie expires in 7 days
        response.addCookie(visitCookie);
        
        // 5. Generate the HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Servlet Visit Tracker</title></head><body style='font-family: Arial;'>");
        out.println("<h2>Welcome to the Visit Tracker</h2>");
        
        if (visitCount == 1) {
            out.println("<p>Welcome! It looks like this is your <b>first time</b> visiting this servlet.</p>");
        } else {
            out.println("<p>Welcome back! You have visited this page <b>" + visitCount + "</b> times.</p>");
        }
        
        out.println("<p><i>Refresh your browser to see the counter increase.</i></p>");
        out.println("</body></html>");
    }
}