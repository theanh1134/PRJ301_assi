<%-- 
    Document   : viewgrade
    Created on : Mar 18, 2024, 1:15:28 PM
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
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade Page</title>
    </head>
     <body>
    <h1>View Grade</h1>
    <form action="testscore" method="POST">
        <label for="Groupid">Group ID:</label>
        <input type="text" id="Groupid" name="gid">
        <input type="submit" value="Search">
    </form>

    <form action="updateGrade" method="POST">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Group Name</th>
                <th>Student Name</th>
                <th>Style Exam</th>
                <th>Weight</th>
                <th>Grade Value</th>
            </tr>     
            <c:forEach var="lg" items="${testscore}">
                <tr>
                    <td>${lg.id}</td>
                    <td>${lg.group.name}</td>                  
                    <td>${lg.student.name}</td>    
                    <td>${lg.typegrade.name}</td>
                    <td>${lg.typegrade.weight}</td>
                     <td>
                    <input type="hidden" name="gradeId_${lg.id}" value="${lg.id}">
                    <input type="text" name="gradeValue_${lg.id}" value="${lg.gradevalue}">
                </td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
