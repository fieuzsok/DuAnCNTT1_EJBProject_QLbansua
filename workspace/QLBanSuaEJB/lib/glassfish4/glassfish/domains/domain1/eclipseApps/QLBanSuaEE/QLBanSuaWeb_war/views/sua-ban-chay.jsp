<%-- 
    Document   : sua-ban-chay
    Author     : lxthao
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page3" class="main">
    <div class="col1">
        <p>Danh sách sữa bán chạy</p>
        <ul>
            <c:forEach items = "${suaLst}" var="Sua" begin="0" end="4" step="1">
                <li><a href="trang-sua-ban-chay.jsp?maSua=${Sua.ma_sua}">${Sua.ten_sua}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp" %>
        </div>       
            <table>
	            <tr>
	                <td colspan="2" class="tieu-de-sua">${tenSua}</td>
	            </tr>
	            <tr>
	                <td><img src="./images/${hinhAnh }"></td>
	                <td>
	                    <p><b><i>Thành phần dinh dưỡng:</i></b><br>${thanhPhan }</p>
	                    <p><b><i>Lợi ích:</i></b><br>${loiIch }</p>
	                    <fmt:formatNumber value="${donGia}" type="number" var="donGia"/>
	                    <p><b><i>Trọng lượng:</i></b> ${trongLuong } gr - <b><i>Đơn giá:</i></b> ${donGia} đ</p>
	                </td>
	            </tr>
	        </table>       
    </div>
</div>