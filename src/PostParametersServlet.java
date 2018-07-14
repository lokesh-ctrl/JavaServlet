import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class PostParametersServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter printWriter = servletResponse.getWriter();
        Enumeration enumeration = servletRequest.getParameterNames();
        while (enumeration.hasMoreElements()){
            String employeeName = (String) enumeration.nextElement();
            printWriter.write(employeeName+"=");
            String empolteeNameValue = servletRequest.getParameter(employeeName);
            printWriter.write(empolteeNameValue);
        }
        printWriter.close();
    }
}
