<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Lecturer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h2 {
            color: #333;
            text-align: center;
        }

        form {
            width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box; 
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Insert New Lecturer</h2>
    <form action="insert" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name">

        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender" placeholder="Enter gender">

        <label for="email">Email:</label>
        <input type="email" id="email" name="email">

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone">

        <label for="address">Address:</label>
        <input type="text" id="address" name="address">

        <label for="departmentId">Department ID:</label>
        <input type="text" id="departmentId" name="departmentId">

        <input type="submit" value="Submit">
    </form>
</body>
</html>
