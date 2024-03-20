<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Profile</title>
</head>
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
<body>
    <h1>Student Profile</h1>
    <form action="studentprofile" method="POST">
        <label for="groupId">Group ID:</label>
        <input type="text" id="groupId" name="gid">
        <input type="submit" value="Search">
    </form>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Group</th>
            <th>Semester</th>
        </tr>     
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.gender} </td>
                    <td>${student.address} </td>
                    <td>${student.phone} </td>
                    <td>${student.email} </td>
                    <td>${student.group.name} </td>
                    <td>${student.semester.name} </td>
                </tr>
            </c:forEach>
       
    </table>
</body>
</html>
