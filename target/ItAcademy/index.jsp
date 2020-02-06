<html>
<body>
<form action = "${pageContext.request.contextPath}/boo" method = "POST">
    Name : <input type = "text" name="name"/>
    <br/>
    Email : <input type = "text" name="email"/>
    <br/>
    Course : <input type="text" name="course"/>
    <br/>
    Online : <input type="checkbox" name="online"/>
    <input type="submit" value = "Send"/>
</form>
</body>
</html>
