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

        input.card_number {
            font-size: 32px;
            width: 360px;
        }


        div {
            font-size: 32px;
        }

    </style>
</head>
<body>
<h1>Enter your card number</h1>
<hr/>
<div align="center">
<form name="credit_card_form" method="post" action="/check_card_number">
    <div>
    <input id="tbInput" type="text" class="card_number" name="card_number"
           pattern="[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}">
        <br>
        <input type="submit" class="button" value="OK">
        <input type="reset" class="button" value="Cancel">
    </div>
</form>
</div>
<br>
<div id="VirtualKey" align="center">
    <input id="btn1" class="button" type="button" value="1" onclick="input(this);" />
    <input id="btn2" class="button" type="button" value="2" onclick="input(this);" />
    <input id="btn3" class="button" type="button" value="3" onclick="input(this);" />
    <br />
    <input id="btn4" class="button" type="button" value="4" onclick="input(this);" />
    <input id="btn5" class="button" type="button" value="5" onclick="input(this);" />
    <input id="btn6" class="button" type="button" value="6" onclick="input(this);" />
    <br />
    <input id="btn7" class="button" type="button" value="7" onclick="input(this);" />
    <input id="btn8" class="button" type="button" value="8" onclick="input(this);" />
    <input id="btn9" class="button" type="button" value="9" onclick="input(this);" />
    <br />
    <input id="btn0" class="button" type="button" value="0" onclick="input(this)" />
    <input id="btnDel" class="button" type="button" value="Backspace" onclick="del();" />
</div>
<script>

    function input(e) {
        var tbInput = document.getElementById("tbInput");
        tbInput.value = tbInput.value + e.value;

        var code = tbInput.value.replace(/[^\d]/g, '').substring(0, 16);
        code = code != '' ? code.match(/.{1,4}/g).join('-') : '';
        tbInput.value = code;


    }

    function del() {
        var tbInput = document.getElementById("tbInput");
        tbInput.value = tbInput.value.substr(0, tbInput.value.length - 1);

        var code = tbInput.value.replace(/[^\d]/g, '').substring(0, 16);
        code = code != '' ? code.match(/.{1,4}/g).join('-') : '';
        tbInput.value = code;
    }

</script>

</body>
</html>
