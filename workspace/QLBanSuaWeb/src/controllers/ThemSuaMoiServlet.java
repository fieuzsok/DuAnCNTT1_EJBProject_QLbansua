package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entityBeans.HangSua;
import entityBeans.LoaiSua;
import entityBeans.Sua;
import sessionBeans.HangSuaSBLocal;
import sessionBeans.LoaiSuaSBLocal;
import sessionBeans.SuaSBLocal;

@WebServlet("/ThemSuaMoiServlet")
public class ThemSuaMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private SuaSBLocal suaSB;
	@EJB
	private LoaiSuaSBLocal loaiSuaSB;
	@EJB
	private HangSuaSBLocal hangSuaSB;
	
    public ThemSuaMoiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        List<LoaiSua> loaiSuaLst = loaiSuaSB.docTatCa3();
        List<HangSua> hangSuaLst = hangSuaSB.getAll();
        
        String submit = request.getParameter("btnThemMoi");
        
        if(submit !=null){
        	String maSua = request.getParameter("txtMaSua");
        	String tenSua = request.getParameter("txtTenSua");
        	String maHangSua = (String) request.getParameter("cboHangSua");
        	System.out.println(maHangSua);
        	HangSua hangSua =  (HangSua) hangSuaSB.getHangByID(maHangSua);
        	String maLoaiSua = (String) request.getParameter("cboLoaiSua");
        	LoaiSua loaiSua =  (LoaiSua) loaiSuaSB.getLoaiByID(maLoaiSua);
        	int trongLuong = Integer.parseInt(request.getParameter("txtTrongLuong"));
        	int donGia = Integer.parseInt(request.getParameter("txtDonGia"));
        	String tpDD = request.getParameter("txtTPDinhDuong");
        	String loiIch = request.getParameter("txtLoiIch");
        	String hinh = request.getParameter("txtHinh");
        	Sua sua = new Sua();
        	sua.setHangSua(hangSua);
        	sua.setDon_gia(donGia);
        	sua.setMa_sua(maSua);;
        	sua.setLoi_ich(loiIch);;
        	sua.setLoaiSua(loaiSua);
        	sua.setHinh(hinh);
        	sua.setTen_sua(tenSua);
        	sua.setTrong_luong(trongLuong);
        	sua.setTp_dinh_duong(tpDD);
        	//Sua sua = new Sua(maSua, tenSua, hangSua, loaiSua, tpDD, trongLuong, donGia, hinh);
        	suaSB.insertSua(sua);
        }
        request.setAttribute("hangSuaLst", hangSuaLst);
        request.setAttribute("loaiSuaLst", loaiSuaLst);
        request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
