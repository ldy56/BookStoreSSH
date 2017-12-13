<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>书籍库存登记系统</title>
    </head>
    <body>
        <center>
            <table width="80%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FF0000">
                <tr>
                    <td colspan="2">
                        <img src="${pageContext.request.contextPath}/img/banner.png" alt="书籍库存登记系统" width="100%" />
                    </td>
                </tr>
                <tr>
                    <td width="22%" height="480" valign="top" background="${pageContext.request.contextPath}/img/bg_left.png">
                        <br /><br />
                        <center><p><font color="#13598b" size="4">
                            <img src="${pageContext.request.contextPath}/img/icon_listlia.gif" />
                            <a href="${pageContext.request.contextPath}/index.jsp"><B>首&nbsp;&nbsp;&nbsp;&nbsp;页</B></a>
                        </font></p></center>
                        <center><p><font color="#13598b" size="4">
                            <img src="${pageContext.request.contextPath}/img/icon_listlia.gif" /> 
                            <a href="${pageContext.request.contextPath}/admin/BookRegister.jsp"><B>入库登记</B></a>
                        </font></p></center>
                        <center><p><font color="#13598b" size="4">
                            <img src="${pageContext.request.contextPath}/img/icon_listlia.gif" /> 
                            <a href="${pageContext.request.contextPath}/admin/selectAllBook"><B>库存列表</B></a>
                        </font></p></center>
                    </td>
                    <td width="78%" valign="top" align="left">
                        <br />
                        <h3>&nbsp;&nbsp;图书详情</h3>             
                        <p>书 名：${book.bookname}</p>
                        <p>类 别：${book.sort}</p>
                        <p>作 者：${book.authorname}</p>
                        <p>折 扣：${book.discount}</p>
                        <p>价 格：${book.price}</p>                        
                        <p>数 量：${book.number}</p>
                        <p>简 介：${book.intro}</p>
                    </td>
                </tr>
            </table>
        <center>
    </body>
</html>