package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BInsertService implements boardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");

		//7. insertForm 에서 입력한 subject, content, writer 를 받아와 알맞는 변수에 입력하세요.
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		BoardDto dto = new BoardDto(0, id, pwd, name, email, null); 
		BoardDao dao = new BoardDao();
		dao.insert(dto);
		
//		response.sendRedirect("list.jsp");

	}

}
