<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Add1</title></head>
<body>
<p>The sum of <%= request.getParameter("a") %>
and <%= request.getParameter("b") %> is
<%= Integer.parseInt(request.getParameter("a"))
+ Integer.parseInt(request.getParameter("b")) %>
</p>
</body>
</html>
