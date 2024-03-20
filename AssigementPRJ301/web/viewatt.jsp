
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        form {
            margin: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        input[type="submit"] {
            padding: 5px;
            border: 1px solid #ccc;
        }

        input[type="text"],
        input[type="date"] {
            width: 200px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        table {
            border-collapse: collapse;
            margin: 20px;
        }

        th,
        td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
   <body>
    <h1>View Attendance</h1>
    <form action="viewattendance" method="POST">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="sid">
        <input type="submit" value="Search">
    </form>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
             <th>Email</th>
            <th>Description</th>
            <th>Class</th>
             <th>Date</th>
        </tr>     
            <c:forEach var="att" items="${attendances}">
                <tr>
                    <td>${att.student.id}</td>
                    <td>${att.student.name} </td>                  
                    <td>${att.student.email} </td>    
                    <td>${att.description} </td>
                     <td>${att.lession.group.name} </td>
                      <td>${att.lession.date} </td>
                </tr>
            </c:forEach>
              
    </table>
</body>
</html>
