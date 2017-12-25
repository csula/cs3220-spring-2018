<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <%-- JSP Comment --%>
        <!-- HTML comments -->

        ${true}, ${false}

    ${23}

    ${6.5}, ${1.1e13}

    ${"double-quoted string"}, ${'single-quoted string'}

    ${null}

    Hello, ${user.firstName} ${user.lastName}

    Servlet Path: ${pageContext.request.servletPath}

        <form method="post">
            <label for="a">a: </label>
            <input name="a" id="a" type="text">

            <label for="b">b: </label>
            <input name="b" id="b" type="text">

            <button>Add</button>
        </form>
    </body>
</html>
