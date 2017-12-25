<%! int counter = 1; %>             <%-- JSP variable declaration --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter</title>
</head>
<body>You are visitor #
<%= counter %>.                     <%-- JSP expression --%>
<% ++counter; %>                    <%-- JSP Scriplet --%>
</body>
</html>
