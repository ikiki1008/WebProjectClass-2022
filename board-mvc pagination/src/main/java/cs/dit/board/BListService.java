package cs.dit.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BListService implements boardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numofRecords = 10; //한 화면에 보여지는 게시글의 개수
		int numofPages = 5; //한 화면에 보여지는 페이지의 개수
		int lastNum = 0;
		int startNum = 0;
		int p = 1; //현재 페이지 번호
		
		p = Integer.parseInt(request.getParameter("p"));
		BoardDao dao = new BoardDao();
		startNum = p-(p-1) % numofPages;
		System.out.println(startNum);
		
		
		int count = dao.recordCount();
		
		lastNum = (int)(Math.ceil((float)count/(float)numofRecords));
		ArrayList<BoardDto> dtos = dao.list(p,numofRecords );
		System.out.println(lastNum);
		
//		System.out.println("dtos의 갯수 : " + dtos.size());
		
		//5. 이 페이지의 저장소인 requestScope에 DB에서 검색해온 dtos 값을 저장하시오.
		request.setAttribute("dtos", dtos);
		request.setAttribute("numofRecords", numofRecords);
		request.setAttribute("numofPages", numofPages);
		request.setAttribute("lastNum", lastNum);
		request.setAttribute("startNum", startNum);
		request.setAttribute("p", p);
		
		
		

	}

}
