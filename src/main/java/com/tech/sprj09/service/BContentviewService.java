//package com.tech.sprj09.service;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.ui.Model;
//
//import com.tech.sprj09.dao.BoardDao;
//import com.tech.sprj09.dto.BoardDto;
//
//
//public class BContentviewService implements BServiceInter{
//
//	@Override
//	public void execute(Model model) {
//		System.out.println(">>>>>>>>BContentviewService");
//		//db 접속셀렉트 글번호 조건
//		
//		Map<String, Object> map=model.asMap();//map으로 변환
//		HttpServletRequest request=(HttpServletRequest) map.get("request");
//		
//		String bid=request.getParameter("bid");
//		String bgroup=request.getParameter("bgroup");
//		//System.out.println(bid);
//		
//		BoardDao dao=new BoardDao();
//		BoardDto dto=dao.contentview(bid,bgroup);
//		//리턴받은 db의 선택글을 모델에 담기
//		model.addAttribute("content_view", dto);
//		
//	}
//
//}
