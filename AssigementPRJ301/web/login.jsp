<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FPT Education Login</title>
      <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url('https://cafefcdn.com/203337114487263232/2021/2/1/photo-1-16121599671671144776037.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
        }
        .container {
            width: 300px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8); 
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        input[type="text"],
        input[type="password"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin: 5px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
            display: block;
        }
        input[type="submit"] {
            width: calc(100% - 22px);
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            display: block;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error-message {
            color: red;
            margin-bottom: 10px;
            text-align: center;
        }
        .logo {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <img class="logo" src="data:image/png;base64,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" alt="FPT Education " width="150">
        <h1>FPT Login</h1>
        <form action="login" method="post">
            <div class="error-message">${error}</div>
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="checkbox" name="remember" value="remember"/> Remember me!
            <br/>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>
