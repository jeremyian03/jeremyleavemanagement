<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f0f8ff; /* Light Blue Background */
            color: #333;
            margin: 50px auto;
            width: 300px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #ff69b4; /* Pink for heading */
            text-align: center;
        }
        label {
            color: #800000; /* Maroon */
        }
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            background-color: #ff4500; /* Red */
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #ffd700; /* Yellow on Hover */
        }
    </style>
</head>
<body>
    <h2>User Registration</h2>
    <form action="auth?action=register" method="post">
        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br>
        <label for="contactNumber">Contact Number:</label><br>
        <input type="text" id="contactNumber" name="contactNumber" required><br>
        <label for="emailAddress">Email Address:</label><br>
        <input type="email" id="emailAddress" name="emailAddress" required><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>