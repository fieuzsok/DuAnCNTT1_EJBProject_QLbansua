package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.*;

import entityBeans.HangSua;
import entityBeans.LoaiSua;
import entityBeans.Sua;
import sessionBeans.SuaSBLocal;
import sessionBeans.HangSuaSBLocal;
import sessionBeans.LoaiSuaSBLocal;

@WebServlet("/DanhSachSuaServlet")
public class DanhSachSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhSachSuaServlet() {
        super();
    }
    
    @EJB
    private HangSuaSBLocal hangSua;
    @EJB
    private LoaiSuaSBLocal loaiSua;
    @EJB
    private SuaSBLocal dsSuaSB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    List<HangSua> dsHangSua = hangSua.getAll();
	    List<LoaiSua> dsLoaiSua = loaiSua.docTatCa3();
	    List<Sua> dsSua;
	    int sumRow = 0;
	    int sumPage = 0;
	    String paramHangSua = request.getParameter("maHang");
	    String page = request.getParameter("trang");
	    String paramLoaiSua = request.getParameter("maLoai");
	    if (paramHangSua!= null){
		   System.out.println(paramHangSua);
		   dsSua = dsSuaSB.getSuaByMaHang(paramHangSua);   	  
	    }
	    else{
    	   paramHangSua = "DL";
    	   dsSua = dsSuaSB.getSuaByMaHang(paramHangSua);
    	   System.out.println(dsSua.get(0).getDon_gia());    	      
	    }if (paramLoaiSua!= null){
    	   dsSua = dsSuaSB.getSuaByMaLoai(paramLoaiSua);   	  
	    }       
	    if(dsSua != null){
    	   sumRow = dsSua.size();
    	   sumPage = ((sumRow)%5 <=0) ? (sumRow/5) : (sumRow/5)+1;
    	   if(page != null){
        	   int pageCurrent = Integer.parseInt(page);
        	   int from= (pageCurrent-1) *5 ;
        	  
        	   if (paramHangSua!= null){
        		   System.out.println(sumPage);
        		   request.setAttribute("param.maHang", paramHangSua);
        		   dsSua = dsSuaSB.getLimitByHang(paramHangSua, from, 5);
        	   }        	   
        	   if (paramLoaiSua!= null){
        		   System.out.println(sumPage);
        		   request.setAttribute("param.maLoai", paramLoaiSua);
        		   dsSua = dsSuaSB.getLimitByLoai(paramLoaiSua, from, 5);
        	   }
           }
	    }
        request.setAttribute("hangSuaLst", dsHangSua);
        request.setAttribute("loaiSuaLst", dsLoaiSua);
        request.setAttribute("suaLst", dsSua);
        request.setAttribute("tongSoTrang", sumPage);
       
        request.getRequestDispatcher("views/danh-sach-sua.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
