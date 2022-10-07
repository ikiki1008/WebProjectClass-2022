package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BViewService implements boardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		
		BoardDto dto = new BoardDto(bcode, null, null, null, null);
		BoardDao dao = new BoardDao();
		
		//6. BoardDao에 정의된 selectOne 메소드를 호출하여 원하는 레코드를 dto에 저장하시오.
		dto = dao.selectOne(bcode);
		 
		
		request.setAttribute("dto", dto);

	}

}