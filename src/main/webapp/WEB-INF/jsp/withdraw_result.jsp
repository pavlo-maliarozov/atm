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
<h1 align="center">Operation result</h1>
<table align="center">
    <tr>
        <td>Card number</td>
        <td>Date</td>
        <td>Time</td>
        <td>Withdraw</td>
        <td>balance</td>
    </tr>
    <tr>
        <td>${opWithdraw.cardNumber}</td>
        <td>${opWithdraw.date}</td>
        <td>${opWithdraw.time}</td>
        <td>${withdraw}</td>
        <td>${opWithdraw.balance}</td>
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
