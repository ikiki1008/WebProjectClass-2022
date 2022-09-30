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
			boardService service = new BListService();
			service.execute(request,response);
			
			viewPage = "/WEB-INF/view/list.jsp";
			
		}else if(com != null && com.equals("insertForm")){
			
			boardService service = new BInsertService();
			service.execute(request,response);
			viewPage = "/WEB-INF/view/insertForm.jsp";
			
			
		}else if(com != null && com.equals("updateForm")){
			
			boardService service = new BViewService();
			service.execute(request,response);
			viewPage = "/WEB-INF/view/updateForm.jsp";
			
			
		}else if(com != null && com.equals("update")){
			boardService service = new BUpdateService();
			service.execute(request,response);
			viewPage = "list.do";
			
			
		}else if(com != null && com.equals("insert")) {
			viewPage = "/WEB-INF/view/insertForm.jsp";
			boardService service = new BInsertService();
			service.execute(request,response);
	
		}
		else if(com != null && com.equals("index")) {
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
