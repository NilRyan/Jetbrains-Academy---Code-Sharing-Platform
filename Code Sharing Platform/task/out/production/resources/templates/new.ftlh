<html lang="en">
<head>
    <title>Create</title>
</head>
<body>
<textarea id="code_snippet">...</textarea> <br>
<label for="time_restriction">
    time limit
</label>
<input id="time_restriction" type="number"/>

<label form="views_restriction">view limit</label>
<input id="views_restriction" type="number"/>

<button id="send_snippet" type="submit" onclick="send()">Submit</button>
<script>
function send() {
let object = {
"code": document.getElementById("code_snippet").value,
"time": document.getElementById("time_restriction").value,
"views": document.getElementById("views_restriction").value
};

let json = JSON.stringify(object);

let xhr = new XMLHttpRequest();
xhr.open("POST", '/api/code/new', false)
xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
xhr.send(json);

if (xhr.status == 200) {
alert("Success!");
}
}
</script>

</body>
</html>