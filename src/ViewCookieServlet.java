import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        PrintWriter printWriter = res.getWriter();
        printWriter.write("<b>");
        for (int i=0;i<cookies.length;i++){
            printWriter.write(i);
            printWriter.write("name of cookie = "+cookies[i].getName());
            printWriter.write("value of cookie="+ cookies[i].getValue());
        }
    }
}
