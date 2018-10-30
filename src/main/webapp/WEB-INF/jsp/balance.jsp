<!DOCTYPE html>
<html>
<head><title>SpringBoot</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

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

<table>
    <tr>
        <th>Card Number</th>
        <th>Date</th>
        <th>Balance</th>
    </tr>
    <tr>
        <td>${operation_info.cardNumber}</td>
        <td>${operation_info.date}</td>
        <td>${operation_info.balance}</td>
    </tr>

</table>

<div align="center">
    <form method="post">
        <input type="submit" class="button" value="Back" formaction="/operations">
        <input type="submit" class="button" value="Exit" formaction="/">
    </form>
</div>


</body>
</html>
