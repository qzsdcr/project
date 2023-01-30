package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj09.dao.BoardDao;
import com.tech.sprj09.dto.BoardDto;


public class BReplyviewService implements BServiceInter{

	@Override
	public void execute(Model model) {
		System.out.println(">>>>>>>>BReplyviewService");
		//db 접속셀렉트 글번호 조건
		
		Map<String, Object> map=model.asMap();//map으로 변환
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String bid=request.getParameter("bid");
		//System.out.println(bid);
		
		BoardDao dao=new BoardDao();
		BoardDto dto=dao.replyview(bid);
		//리턴받은 db의 선택글을 모델에 담기
		model.addAttribute("reply_view", dto);
		
	}

}
