import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String parameters = req.getParameter("employeeName");
        Cookie cookie = new Cookie("mycookie",parameters);
        res.addCookie(cookie);
        res.setContentType("text/html");
        PrintWriter printWriter = res.getWriter();
        printWriter.write("<h1>added cookie call \"/viewcookie\" to view cookie</h1>");
        printWriter.close();
    }
}
