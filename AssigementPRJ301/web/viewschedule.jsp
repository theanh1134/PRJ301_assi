<%-- 
    Document   : viewschedule
    Created on : Mar 18, 2024, 12:33:17 PM
    Author     : Laptop K1
--%>

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
    <h1>View Exam Schedule</h1>
    <form action="examschedule" method="POST">
        <label for="lecturerID">Lecturer ID:</label>
        <input type="text" id="lecturerID" name="lid">
        <input type="submit" value="Search">
 ${error}
    </form>
   
    <h1>View Exam Schedule</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Subject Name</th>
            <th>Date</th>
            <th>Type Exam</th>
            <th>Room</th>
            <th>Time Slot</th>
            <th>Lecturer Name</th>
        </tr>     
        <c:forEach var="ex" items="${examList}">
            <tr>
               
                <td>${ex.id}</td>
                <td>${ex.subject.name}</td>                  
                <td>${ex.date}</td>    
                <td>${ex.typegrade.name}</td>
                <td>${ex.room.name}</td>
                <td>${ex.slot.name}</td>
                <td>${ex.lecturer.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
