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
//public class BDeleteService implements BServiceInter {
//
//	@Override
//	public void execute(Model model) {
//		System.out.println("삭제!");
//		
//		Map<String, Object> map=model.asMap();//map으로 변환
//		HttpServletRequest request=(HttpServletRequest) map.get("request");
//		
//		String bid=request.getParameter("bid");
//		String bgroup=request.getParameter("bgroup");
//		
//		BoardDao dao=new BoardDao();
//		dao.delete(bid,bgroup);
//		
//		
//		
//	}
//	
//
//}
