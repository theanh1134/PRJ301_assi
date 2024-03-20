<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Options</title>
</head>
  <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
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

        .update-form, .delete-form {
            margin-top: 10px;
        }

        .update-form input[type="text"], .delete-form input[type="submit"] {
            padding: 8px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        .update-form input[type="text"] {
            width: calc(100% - 120px);
            margin-bottom: 5px;
        }

        .delete-form input[type="submit"] {
            background-color: #f44336;
        }

        .update-form input[type="submit"]:hover, .delete-form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
<body>
    <h2>List of Lecturers</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Department</th>
            <th>Action</th>
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
                <td colspan="2">
                    <button class="show-update-form" data-id="${lecturer.id}">Update</button>
                 <form class="update-form" action="update" method="post" data-id="${lecturer.id}" style="display: none">
    <input type="hidden" name="id" value="${lecturer.id}">
    <table>
        <tr>
            <td><label for="name">Name:</label></td>
            <td><textarea id="name" name="name">${lecturer.name}</textarea></td>
        </tr>
        <tr>
            <td><label for="gender">Gender:</label></td>
            <td>
                <select id="gender" name="gender">
                    <option value="male" ${lecturer.gender == 'male' ? 'selected' : ''}>Male</option>
                    <option value="female" ${lecturer.gender == 'female' ? 'selected' : ''}>Female</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="email">Email:</label></td>
            <td><textarea id="email" name="email">${lecturer.email}</textarea></td>
        </tr>
        <tr>
            <td><label for="phone">Phone:</label></td>
            <td><textarea id="phone" name="phone">${lecturer.phone}</textarea></td>
        </tr>
        <tr>
            <td><label for="address">Address:</label></td>
            <td><textarea id="address" name="address">${lecturer.address}</textarea></td>
        </tr>
        <tr>
            <td><label for="departmentId">Department ID:</label></td>
            <td><input type="text" id="departmentId" name="departmentId" value="${lecturer.department.id}"></td>
        </tr>
    </table>
    <input type="submit" value="Update">
</form>




                    <form class="delete-form" action="delete" method="post" data-id="${lecturer.id}">
                        <input type="hidden" name="id" value="${lecturer.id}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script>
        document.querySelectorAll('.show-update-form').forEach(function(button) {
            button.addEventListener('click', function() {
                var lecturerId = button.getAttribute('data-id');
                var updateForm = document.querySelector('.update-form[data-id="' + lecturerId + '"]');
                if (updateForm.style.display === 'none') {
                    updateForm.style.display = 'block';
                } else {
                    updateForm.style.display = 'none';
                }
            });
        });
    </script>
</body>
</html>
