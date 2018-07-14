import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{
        String reqprotocal = req.getProtocol();
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.write("<B>protocaltype = "+ reqprotocal+"Method type is Get");
        pw.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{
        String reqprotocal = req.getProtocol();
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.write("<B>protocaltype = "+ reqprotocal+"Method type is POst");
        pw.close();

    }

}
