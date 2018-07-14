<%--
  Created by IntelliJ IDEA.
  User: rlokesh
  Date: 14/07/18
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
  <form name="EmployeeForm"
        method="post"
        action="http://localhost:8080/PostData">
    <table> <tr>
      <td><B>Employee Name:</B></td>
      <td><input type=textbox name="employeeName" size="25" value=""></td>
    </tr>
      <tr>
        <td><B>Enter Phone Number:</B></td>
        <td><input type=textbox name="phoneNumber" size="25" value=""></td>
      </tr>
    </table>
    <input type=submit value="Submit">
</body>
</html>