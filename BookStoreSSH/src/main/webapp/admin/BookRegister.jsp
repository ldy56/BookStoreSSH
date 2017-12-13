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
                            <a href="${pageContext.request.contextPath}//admin/selectAllBook"><B>库存列表</B></a>
                        </font></p></center>
                    </td>
                    <td width="78%" valign="top" align="left">
                        <br />
                        <h3>&nbsp;&nbsp;添加图书</h3>
                        <c:if test="${not empty errors}">
                        	<c:forEach items="${errors}" var="err">
                        		<li>${err}
                        	</c:forEach>
                        </c:if>
                        <table>                        	
	                        <form action="${pageContext.request.contextPath}/admin/addBook" method="post">
	                        	<input type="hidden" name="status" value="insert">
	                        	<tr>
	                        		<td>书 名：</td>
	                        		<td>
	                        			<input type="text" name="bookname" value="${param.bookname}">
	                        		</td>
	                        	</tr>
	                        	<tr>
	                        		<td>类 别：</td>
	                        		<c:set var="sorts" value="科学,教育,文学,生活,其他"></c:set>
	                        		<td>
	                        			<c:forEach items="${sorts}" var="cate">
	                        				<input type="checkbox" name="sort" value="${cate}"
	                        					<c:forEach items="${paramValues.sorts}" var="selCate">
	                        						<c:if test="${cate == selCate}">
	                        							checked
	                        						</c:if>
	                        					</c:forEach> 
	                        				>${cate}
	                        			</c:forEach>
	                        			
	                        		</td>
	                        	</tr>
	                        	<tr>
	                        		<td>作 者：</td>
	                        		<td>
	                        			<input type="text" name="authorname" value="${param.authorname}">
	                        		</td>
	                        	</tr>
	                        	<tr>
	                        		<td>折 扣：</td>
	                        		<c:set var="discounts" value="全价,九折,八折,七折,六折"></c:set>
	                        		<td>
	                        			<c:forEach items="${discounts}" var="disc">
	                        				<input type="radio" name="discount" value="${disc}" 
	                        					<c:if test="${disc == param.discount}">
	                        						checked
	                        					</c:if>
	                        				>${disc}
	                        			</c:forEach>
	                        			
	                        		</td>
	                        	</tr>
	                        	<tr>
	                        		<td>价 格：</td>
	                        		<td>
	                        			<input type="text" name="price" value="${param.price}">
	                        		</td>
	                        	</tr>
	                        	<tr>
	                        		<td>数 量：</td>
	                        		<td>
	                        			<input type="text" name="number" value="${param.number}">
	                        		</td>
	                        	</tr>
	                        	<tr>
	                        		<td>简 介：</td>
	                        		<td>
	                        			<textarea rows="3" cols="30" name="intro">${param.intro}</textarea>
	                        		</td>
	                        	</tr>
	                        	<tr>
	                   				<td colspan="2">
	                   					<input type="submit" value="登记">
	                   					<input type="reset" value="取消">
	                   				</td>
	                        </form>
                        </table>
                    </td>
                </tr>
            </table>
        <center>
    </body>
</html>