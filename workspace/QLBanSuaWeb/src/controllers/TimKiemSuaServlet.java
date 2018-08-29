package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionBeans.HangSuaSBLocal;
import sessionBeans.LoaiSuaSBLocal;
import sessionBeans.SuaSBLocal;
import entityBeans.HangSua;
import entityBeans.LoaiSua;
import entityBeans.Sua;

@WebServlet("/TimKiemSuaServlet")
public class TimKiemSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SuaSBLocal suaSB;
	@EJB
	private LoaiSuaSBLocal loaiSuaSB;
	@EJB
	private HangSuaSBLocal hangSuaSB;
    public TimKiemSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        List<Sua> suaLst;
        List<LoaiSua> loaiSuaLst = loaiSuaSB.docTatCa3();
        List<HangSua> hangSuaLst = hangSuaSB.getAll();
        String find = request.getParameter("btnTimKiem");
        String word = request.getParameter("txtTenSuaTim");
        String maHang  = request.getParameter("cboHangSua");
        String loaiSua = request.getParameter("cboLoaiSua");
        int soSp = 0;
        if(find != null && !maHang.equals("") && !loaiSua.equals("")){
        	suaLst = suaSB.findByHangAndLoai(maHang, loaiSua, word);
        	soSp = suaLst.size(); 
        	request.setAttribute("suaLst", suaLst);
        	System.out.println(maHang + " " + loaiSua);
        }
        else if(find != null && !maHang.equals("")){
        	suaLst = suaSB.findByMaHang(maHang, word);
        	soSp = suaLst.size();        	
        	request.setAttribute("suaLst", suaLst);
        	System.out.println(maHang + "2");
        }
        else if(find != null && !loaiSua.equals("")){
        	suaLst = suaSB.findByLoaiSua(loaiSua, word);
        	soSp = suaLst.size();        	
        	request.setAttribute("suaLst", suaLst);
        	System.out.println(loaiSua + "3");
        }
        else if(find != null){
        	suaLst = suaSB.findByWord(word);
        	soSp = suaLst.size(); 
        	request.setAttribute("suaLst", suaLst);
        	System.out.println(maHang + " " + loaiSua);
        }
        request.setAttribute("hangSuaLst", hangSuaLst);
        request.setAttribute("loaiSuaLst", loaiSuaLst);
       request.setAttribute("sosp", soSp);
        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
