<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Timetable</title>
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
    <h1>Student Timetable</h1>
    
    <form action="studenttimetable" method="post">
        <label for="id">Student ID:</label>
        <input type="text" id="id" name="id" value="${param.id}">
        
        <label for="from">From:</label>
        <input type="date" id="from" name="from" value="${from}">
        
        <label for="to">To:</label>
        <input type="date" id="to" name="to" value="${to}">
        
        <input type="submit" value="Submit">
    </form>

    <table border="1">
        <thead>
            <tr>
                <th>Date</th>
                <th>Room</th>
                <th>Time Slot</th>
                <th>Lecturer</th>
                <th>Subject</th>
                <th>Group</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="lesson" items="${lessions}">
                <tr>
                    <td>${lesson.date}</td>
                    <td>${lesson.room.name}</td>
                    <td>${lesson.slot.name}</td>
                    <td>${lesson.lecturer.name}</td>
                    <td>${lesson.subject.name}</td>
                    <td>${lesson.group.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
