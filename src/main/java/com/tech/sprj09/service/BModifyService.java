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
//public class BModifyService implements BServiceInter {
//
//	@Override
//	public void execute(Model model) {
//		System.out.println("수정신호오오오오");
//		
//		Map<String, Object> map=model.asMap();//map으로 변환
//		HttpServletRequest request=(HttpServletRequest) map.get("request");
//		
//		String bid=request.getParameter("bid");
//		String bname=request.getParameter("bname");
//		String btitle=request.getParameter("btitle");
//		String bcontent=request.getParameter("bcontent");
//		
//		BoardDao dao=new BoardDao();
//		dao.modify(bid,bname,btitle,bcontent);
//		
//		
//		
//	}
//	
//
//}
