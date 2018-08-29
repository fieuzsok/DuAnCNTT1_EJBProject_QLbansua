package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entityBeans.Sua;
import sessionBeans.SuaSBLocal;

@WebServlet("/SuaBanChayServlet")
public class SuaBanChayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private SuaSBLocal dsSuaSB;
    public SuaBanChayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        List<Sua> suaLst = dsSuaSB.getDSBanChay(); ;
        Sua sua = new Sua();
        if(suaLst != null){
        	request.setAttribute("suaLst", suaLst);
        	 String paramMaSua = request.getParameter("maSua");
             if(paramMaSua != null){
             	sua = dsSuaSB.getByMa(paramMaSua);
             }
             else{
             	paramMaSua = suaLst.get(0).getMa_sua();
             	sua = dsSuaSB.getByMa(paramMaSua);             	
             }
            request.setAttribute("hinhAnh", sua.getHinh());
          	request.setAttribute("tenSua", sua.getTen_sua());
          	request.setAttribute("thanhPhan", sua.getTp_dinh_duong());
          	request.setAttribute("trongLuong", sua.getTrong_luong());
          	request.setAttribute("donGia", sua.getDon_gia());
        }
       
        request.getRequestDispatcher("views/sua-ban-chay.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
