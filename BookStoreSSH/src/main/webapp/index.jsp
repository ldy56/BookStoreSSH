<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <h3>&nbsp;&nbsp;项目目标</h3>
                        <ul>
                            <li>仿真实现一个基于B/S的书籍库存登记系统</li><br />
                            <li>增量式开发，循序渐进完成项目</li><br />
                            <li>掌握Web应用程序编程和调试技巧</li><br />
                            <li>主要涉及以下主要知识点：</li><br />
                            <dd>
                                <li>Model 2架构的实现</li><br />
                                <li>使用Servlet实现控制器，JSP实现视图</li><br />
                                <li>表单的各种组件的处理</li><br />
                                <li>使用DAO模式，通过DataSource访问数据</li><br />
                                <li>在Web应用程序中整合MySQL数据库</li>
                            </dd>
                        </ul>
                    </td>
                </tr>
            </table>
        <center>
    </body>
</html>
