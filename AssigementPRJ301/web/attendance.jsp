<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Attendance Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        form {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        h1 {
            text-align: center;
        }
    </style>
    <script>
        function updateDescription(studentId) {
            var isPresent = document.querySelector('input[name="present'+studentId+'"]:checked').value;
            var descriptionInput = document.getElementById('description' + studentId);
            if (isPresent === 'yes') {
                descriptionInput.value = 'Present';
            } else {
                descriptionInput.value = 'Absent';
            }
        }
    </script>
</head>
<body>
    <h1>Attendance Form</h1>
    <form action="att" method="POST">
        <input type="hidden" name="id" value="${param.id}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Is Presented</th>
                <th>Description</th>
            </tr>
            <c:forEach items="${requestScope.attendances}" var="a">
                <tr>
                    <td>${a.student.id}</td>
                    <td>${a.student.name}</td>
                    <td>
                        <input type="radio" onchange="updateDescription(${a.student.id})" 
                               ${!a.isPresent ? 'checked' : ''} name="present${a.student.id}" value="no"  /> No
                        <input type="radio" onchange="updateDescription(${a.student.id})" 
                               ${a.isPresent ? 'checked' : ''} name="present${a.student.id}" value ="yes" /> Yes
                    </td>
                    <td><input id="description${a.student.id}" name="description${a.student.id}" type="text" value="${a.description}" readonly/></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="Save"/>
    </form>
</body>
</html>
