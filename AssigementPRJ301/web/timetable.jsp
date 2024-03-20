<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Time Table</title>
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
    <form action="LecturerTimetable" method="POST">
        
        <label for="lid">Lecturer ID:</label> 
        <input type="text" id="lid" name="id" value="${id}" />
        <label for="from">From:</label> 
        <input type="date" id="from" name="from" value="${from}" /> 
        <label for="to">To:</label> 
        <input type="date" id="to" name="to" value="${to}" />
        <input type="submit" value="Search"/>
    </form>
   <table border="1px">
    <tr>
        <td>Time Slot</td>
        <c:forEach items="${requestScope.dates}" var="d">
            <td>${d}</td>
        </c:forEach>
    </tr>
    <c:forEach items="${requestScope.slots}" var="slot">
        <tr>
            <td>${slot.name} (${slot.timeFrom} - ${slot.timeTo})</td>
            <c:forEach items="${requestScope.dates}" var="d">
                <td>
                    <c:forEach items="${requestScope.lessions}" var="les">
                        <c:if test="${(les.date eq d) and (les.slot.id eq slot.id)}">
                            ${les.group.name} - ${les.group.subject.name}
                            <a href="att?id=${les.id}"> 
                                <c:if test="${les.attended}">
                                    Edit
                                </c:if>
                                <c:if test="${!les.attended}">
                                    Take
                                </c:if>
                            </a>
                        </c:if>
                    </c:forEach>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>
