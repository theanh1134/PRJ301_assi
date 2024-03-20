<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 16px;
            box-sizing: border-box; /* Fix width issue caused by padding */
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: none;
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Search Lecturer Profile</h1>
        <form action="profile" method="post">
            <!-- Add placeholder for search input -->
            <input type="text" id="id" name="id" placeholder="Enter lecturer you want to search">
            <input type="submit" value="Search">
        </form>
       
       
    <h2>List of Lecturers</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Department</th>
        </tr>
        <c:forEach var="lecturer" items="${lecturers}">
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


                    
    </div>
</body>
</html>
