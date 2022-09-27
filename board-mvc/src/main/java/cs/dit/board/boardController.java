package cs.dit.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uri = request.getRequestURI();
		String viewPage = null;
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		
		
		if(com != null && com.equals("list")) {
//			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
//			rd.forward(request, response);
			viewPage = "/WEB-INF/view/list.jsp";
		}else if(com != null && com.equals("insertForm")){
			viewPage = "/WEB-INF/view/insertFrom.jsp";
		}else if(com != null && com.equals("index")) {
			viewPage = "/WEB-INF/view/index.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
