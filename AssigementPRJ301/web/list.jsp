<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lecturer List</title>
</head>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
<body>
    <h2>Lecturer List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Department</th>
        </tr>
        <c:forEach var="lecturer" items="${lecturerList}">
            <tr>
                <td>${lecturer.id}</td>
                <td>${lecturer.name}</td>
                <td>${lecturer.gender}</td>
                <td>${lecturer.email}</td>
                <td>${lecturer.phone}</td>
                <td>${lecturer.address}</td>
                <td>${lecturer.department.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
