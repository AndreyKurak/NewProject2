<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Message</title>
        <H2>Message about operation execution</H2>
    </head>
    <body>
        <%= request.getSession().getAttribute("view") %>
        <%request.getSession().removeAttribute("view");%>
        <p>
            <a href="<%=request.getContextPath()%>/home">Home Page</a>
        </p>
    </body>
</html>
