<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="java.io.IOException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript">

</script> -->
<title>Insert title here</title>
</head>
<body>
   
    <input type="hidden" name="request-type" value="poll">
    <table border="1">
    
    <tr>
       <th> Fibonacci Request
      </tr>
      <tr>
       <th>Job number:<%=request.getAttribute("jobnum")%></th>
      </tr>
      
       <tr>
       <th>Page will refresh in 10 seconds
      </tr>
 
    </table>
    
  <%
  
   response.addHeader("refresh","10;http://localhost:8080/Myproject/Requestservlett?request-type=poll&num="+request.getAttribute("max")+"&jobnum="+request.getAttribute("jobnum"));
  
   %>
    

</body>
</html>