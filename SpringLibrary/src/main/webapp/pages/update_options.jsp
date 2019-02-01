<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Input options of command Update</title>
        <h2>Input Options of Update command</h2>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/command/update" method="post">
            <table>
                <tr>
                    <td>id</td>
                    <td><input name="id" value="<%if (request.getParameter("id") != null)%><%=request.getParameter("id")%>" type="text"></td>
                    <td><i id="id"></i></td>
                </tr>
                <tr>
                    <td>author</td>
                    <td><input name="author" value="<%if (request.getParameter("author") != null)%><%=request.getParameter("author")%>" type="text"></td>
                    <td><i id="author"></i></td>
                </tr>
                <tr>
                    <td>title</td>
                    <td><input name="title" value="<%if (request.getParameter("title") != null)%><%=request.getParameter("title")%>" type="text"></td>
                    <td><i id="title"></i></td>
                </tr>
                <tr>
                    <td>year</td>
                    <td><input name="year" value="<%if (request.getParameter("year") != null)%><%=request.getParameter("year")%>" type="text"></td>
                    <td><i id="year"></i></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="confirm" id="button1"></td>
                </tr>
            </table>
            <a href="<%=request.getContextPath()%>/home">Home Page</a>
        </form>
    </body>
</html>
