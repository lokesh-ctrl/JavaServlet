import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DatabaseServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "loki", "lokicherry1");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String sql = "SELECT * FROM employees;";

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "loki", "lokicherry1");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            try {
                stmt = c.createStatement();
            } catch (SQLException e1) {
                e1.printStackTrace();
                printWriter.write("exception");
            }
            ResultSet rs = null;
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


            printWriter.println("<HTML>");
            printWriter.println("<HEAD><TITLE>Show Employees</TITLE></HEAD>");
            printWriter.println("<BODY>");
            printWriter.println("<TABLE BORDER=\"1\" CELLPADDING=\"3\">");
            printWriter.println("<TR>");
            printWriter.println("<TH>id</TH>");
            printWriter.println("<TH>name</TH>");
            printWriter.println("</TR>");

            try {

                while (rs.next()) {
                    printWriter.println("<TR>");


                    printWriter.println("<TD>" + rs.getString("id") + "</td>");

                    printWriter.println("<TD>" + rs.getString("name") + "</td>");

                    printWriter.println("</TR>");
                }


                printWriter.println("</TABLE>");
                printWriter.println("</BODY></HTML>");


                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
