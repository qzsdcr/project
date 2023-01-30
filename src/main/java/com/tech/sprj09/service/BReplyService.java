//package com.tech.sprj09.service;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.ui.Model;
//
//import com.tech.sprj09.dao.BoardDao;
//
//public class BReplyService implements BServiceInter{
//
//	@Override
//	public void execute(Model model) {
//		System.out.println(">>>>>>>>Bwrite");
//		//model 에서 request
//		Map<String, Object> map=model.asMap();//map으로 변환
//		HttpServletRequest request=(HttpServletRequest) map.get("request");
//	
//		String bid=request.getParameter("bid");
//		String bgroup=request.getParameter("bgroup");
//		String bstep=request.getParameter("bstep");
//		String bindent=request.getParameter("bindent");
//
//		String bname=request.getParameter("bname");
//		String btitle=request.getParameter("btitle");
//		String bcontent=request.getParameter("bcontent");
//
//		
//		
//		
//		
////		db에 연결해서 sql은 dao에서 처리
//		
//		BoardDao dao=new BoardDao();
//		dao.reply(bid,bgroup,bstep,bindent,bname,btitle,bcontent);
//		
//	}
//
//}
