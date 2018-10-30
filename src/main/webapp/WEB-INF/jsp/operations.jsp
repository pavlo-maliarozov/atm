<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head><title>SpringBoot</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
    border-spacing: 15px;
}

td, th {
    border: 1px solid black;
    text-align: center;
    padding: 4px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
<br>
<H1 align="center">OPERATIONS</H1>
<br>
<br>
<table align="center">
  <tr>
    <td><a href="/get_balance" style="font-size: 80px; text-decoration: none">Balance</a></td>
  </tr>
  <tr>
    <td><a href="/withdraw_money" style="font-size: 80px; text-decoration: none">Withdraw money</a></td>
  </tr>
  <tr>
    <td><a href="/" style="font-size: 80px; text-decoration: none">Exit</a></td>
  </tr>
</table>
</body>
</html>
