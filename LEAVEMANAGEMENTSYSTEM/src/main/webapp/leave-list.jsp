<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Leave List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #fac898;
            color: #333;
        }
        .container {
            margin-top: 50px;
            background: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            position: relative;
            z-index: 2;
        }
        h2 {
            color: #ff69b4;
        }
        .btn-primary {
            background: linear-gradient(90deg, #ff7f7f, #fac898);
            border: none;
        }
        .btn-primary:hover {
            background: linear-gradient(90deg, #ff7f7f, #fac898);
        }
        .btn-warning {
            background-color: #0a5c36;
            border: none;
        }
        .btn-danger {
            background-color: #ff7f7f;
            border: none;
        }
        .btn {
            color: #fff;
        }
        table {
            background-color: #ff7f7f;
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: center;
            padding: 10px;
        }
        th {
            background-color: #ff5a70;
            color: #ffffff;
        }
        td {
            background-color: #ecbd22;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Leave List</h2>
        <a href="new" class="btn btn-primary mb-2">Add New Leave</a>
        <a href="logout" class="btn btn-secondary mb-2">Log Out</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Leave Type</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="leave" items="${listLeave}">
                    <tr>
                        <td>${leave.id}</td>
                        <td>${leave.name}</td>
                        <td>${leave.leaveType}</td>
                        <td>${leave.status}</td>
                        <td>
                            <a href="edit?id=${leave.id}" class="btn btn-warning">Edit</a>
                            <a href="delete?id=${leave.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>