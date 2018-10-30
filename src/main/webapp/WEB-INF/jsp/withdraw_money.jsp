<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head><title>SpringBoot</title>
<style>

  h1 {
    font-size: 32px;
    text-align: center;
  }

  input.button {
    font-size: 32px;
    width: 368px;
    background-color: #4CAF50; /* Green */
    border: black;
    color: white;
    padding: 4px 6px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 8px;
    margin: 15px 15px 15px 15px;
  }

  div {
    font-size: 32px;
  }

</style>
</head>
<body>

<hr/>
<h1>Please, enter amount</h1>
<div align="center">
<form name="withdraw" method="post" action="/calculate_withdraw">
  <input type="text" autocomplete="off" name="withdraw" pattern="{0-9}">
  <br>
  <input type="submit" class="button" value="Withdraw">
  <input type="reset" class="button" value="Cancel">
</form>
</div>
</body>
</html>
