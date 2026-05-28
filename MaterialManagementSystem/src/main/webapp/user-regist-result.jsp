<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iユーザ登録結果</title>
</head>
<body>
 <%
    ArrayList<BookBean> bookList = (ArrayList<BookBean>) request.getAttribute("bookList");
	if(bookList != null) {
    %>

    <h2>書籍検索結果</h2>
    <form action="BookDeleteServlet" method="POST">
        <input type="submit" value="削除">
        <table>
            <tr>
                <td>削除</td>
                <td>No.</td>
                <td>書籍名</td>
                <td>著者名</td>
            </tr>
            <%

                   for(int i = 0; i < bookList.size(); i++) {
                        BookBean book = bookList.get(i);
            %>
            <tr>
                <td>
                    <input type="checkbox" name="delete" value="<%=book.getId()%>">
                </td>
                <td><%=i + 1%></td>
                <td><%=book.getBookTitle()%></td>
                <td><%=book.getAuthorName()%></td>
            </tr>
            <%
                   }
            %>
        </table>
    </form>
    <%} %>
</body>
</html>