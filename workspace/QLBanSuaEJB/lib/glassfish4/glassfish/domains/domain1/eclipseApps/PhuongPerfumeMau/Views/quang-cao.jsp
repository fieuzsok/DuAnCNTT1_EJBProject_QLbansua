<%-- 
    Document   : quang-cao-slider
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div class="slider-area">
	<!-- Slider -->
	<div class="block-slider block-slider4">
		<ul class="" id="bxslider-home4">
			<c:forEach items="${dsqc}" var="qc">
				<li><div class="caption-group">						
					</div><img src="img/${qc.hinhAnh}" alt="${qc.hinhAnh}">
					</li>
			</c:forEach>
		</ul>
	</div>
	<!-- ./Slider -->
</div>
<!-- End slider area -->

<!-- <h2 class="caption title">
							<span class="primary"><strong>${qc.thongDiep}</strong></span>
						</h2>
						<h4 class="caption subtitle">${qc.thongDiep}</h4>
						<a class="caption button-radius" href="#"><span class="icon"></span>Chi
							tiết</a> -->