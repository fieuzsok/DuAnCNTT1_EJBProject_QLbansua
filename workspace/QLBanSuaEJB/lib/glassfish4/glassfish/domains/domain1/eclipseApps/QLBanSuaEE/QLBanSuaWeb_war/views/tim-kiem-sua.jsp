<%-- 
    Document   : tim-kiem-sua
    Author     : lxthao
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page4" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
    <form name="frmTimKiem" action="trang-tim-kiem-sua.jsp" method="post">
        <table border="1">
            <thead>
                <tr>
                    <th>TÌM KIẾM THÔNG TIN SỮA</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        Loại sữa: 
                        <select name="cboLoaiSua">
                        	<option value =""></option>
                            <c:forEach items="${loaiSuaLst}" var="loaiSua" begin="0"  step="1">
                            <option value="${loaiSua.ma_loai_sua }">${loaiSua.ten_loai}</option>
                            </c:forEach>
                        </select>
                 	       
                        Hãng sữa:
                       <select name="cboHangSua">
                       		<option value =""></option>
                            <c:forEach items="${hangSuaLst }" var="hangSua" begin="0" step="1">
                            <option  value="${hangSua.ma_hang_sua}">${hangSua.ten_hang_sua}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Tên sữa: <input type="text" name="txtTenSuaTim" value="" size="30"/>
                        <input type="submit" value="Tìm kiếm" name="btnTimKiem"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <c:if test="${sosp>0}">
        <p><b>Sản phẩm được tìm thấy</b></p>
        <table border="0">
            <c:forEach items="${suaLst}" var="sua" begin="0" step="1">
            <thead>
                <tr>
                    <th colspan="2" class="tieu-de-sua">${sua.ten_sua }</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><img src="./images/${sua.hinh }"></td>
                    <td>
                        <p><b>Thành phần dinh dưỡng:</b><br>${sua.tp_dinh_duong }</p>
                        <p><b>Lợi ích:</b><br>${sua.loi_ich }</p>
                        <fmt:formatNumber type="number" value="${sua.don_gia }" var="donGia"/>
                        <p><b>Trọng lượng:</b> ${sua.trong_luong} gr - <b>Đơn giá:</b> ${donGia} đ</p>
                    </td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </c:if>
    </div>
</div>