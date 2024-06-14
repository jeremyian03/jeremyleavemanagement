<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Login</title>
    <style>
        body {
            background-color: #f4a460;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            position: relative;
        }

        .login-container {
            text-align: center;
            background-color: #ffcc00;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #ff69b4;
            margin-bottom: 20px;
        }

        input[type="text"], input[type="password"] {
            width: 80%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #ff4500;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #e63946;
        }

        .nyan-cat {
            position: absolute;
            top: 30%;
            left: 10px;
            width: 200px;
        }

        .register-link {
            margin-top: 10px;
            display: block;
        }
    </style>
</head>
<body>
    <img src="https://tinyurl.com/yztetx3j" alt="Nyan Cat" class="nyan-cat">
    <div class="login-container">
        <h1>User Login</h1>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="submit" value="Login">
        </form>
        <a href="register.jsp" class="register-link">Don't have an account? Register here.</a>
    </div>
</body>
</html>