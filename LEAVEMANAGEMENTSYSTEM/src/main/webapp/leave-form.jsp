<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Leave Form</title>
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
        .form-group label {
            color: #ff69b4;
        }
    </style>
    <script>
        function toggleOtherLeaveType() {
            var leaveType = document.getElementById('leaveType').value;
            var otherLeaveType = document.getElementById('otherLeaveType');
            if (leaveType === 'Others') {
                otherLeaveType.style.display = 'block';
            } else {
                otherLeaveType.style.display = 'none';
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Leave Form</h2>
        <form action="insert" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="leaveType">Leave Type</label>
                <select class="form-control" id="leaveType" name="leaveType" onchange="toggleOtherLeaveType()" required>
                    <option value="Bereavement leave">Bereavement leave</option>
                    <option value="Sick leave">Sick leave</option>
                    <option value="Maternity leave">Maternity leave</option>
                    <option value="Unpaid leave">Unpaid leave</option>
                    <option value="Paternity leave">Paternity leave</option>
                    <option value="Casual leave">Casual leave</option>
                    <option value="Sabbatical leave">Sabbatical leave</option>
                    <option value="Public holiday">Public holiday</option>
                    <option value="Compensatory leave">Compensatory leave</option>
                    <option value="Personal leave">Personal leave</option>
                    <option value="Jury duty">Jury duty</option>
                    <option value="Marriage leave">Marriage leave</option>
                    <option value="Religious holiday">Religious holiday</option>
                    <option value="Privilege leave">Privilege leave</option>
                    <option value="Study leave">Study leave</option>
                    <option value="Extra time off">Extra time off</option>
                    <option value="Military leave">Military leave</option>
                    <option value="Voting">Voting</option>
                    <option value="Compassionate leave">Compassionate leave</option>
                    <option value="Adoption leave">Adoption leave</option>
                    <option value="Family and Medical Leave Act of 1993">Family and Medical Leave Act of 1993</option>
                    <option value="Loss of pay">Loss of pay</option>
                    <option value="Adverse weather">Adverse weather</option>
                    <option value="Community service leave">Community service leave</option>
                    <option value="Others">Others</option>
                </select>
                <div id="otherLeaveType" style="display:none;">
                    <label for="otherLeave">Please specify</label>
                    <input type="text" class="form-control" id="otherLeave" name="otherLeave">
                </div>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <input type="text" class="form-control" id="status" name="status" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>