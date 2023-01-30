package com.tech.sprj09.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.dto.BoardDto;
import com.tech.sprj09.service.BServiceInter;
import com.tech.sprj09.vopage.SearchVO;

@Controller
public class BController {
	BServiceInter bServiceInter;

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/list")
	public String list(HttpServletRequest request, SearchVO searchVO, Model model) {

		System.out.println("-----------------------list-------------------------");
		// db에서 데이터 가져오기
//		bServiceInter = new BListService();
//		bServiceInter.execute(model);

		IDao dao = sqlSession.getMapper(IDao.class);

		String[] brdtitle = request.getParameterValues("searchType");

		if (brdtitle != null) {//null 처리

			for (int i = 0; i < brdtitle.length; i++) {

				System.out.println("선택한 체크박스 " + brdtitle[i]);
			}

		} 
		
		String btitle="";
		String bcontent="";
		
		if (brdtitle!=null) {
			for (String val : brdtitle) {
				if (val.equals("btitle")) {
					
					model.addAttribute("btitle","true");
					btitle="btitle";
				}else if (val.equals("bcontent")) {
					bcontent="bcontent";
					model.addAttribute("bcontent","true");
				}
			}
		}
		
		//키워드 가져오기
		String searchKeyword=request.getParameter("sk");
		if (searchKeyword==null) 
			searchKeyword="";
		
		model.addAttribute("resk",searchKeyword);
		
		System.out.println("keyword ::"+searchKeyword);
		
		

		String strpage = request.getParameter("page");
		if (strpage == null) {
			strpage = "1";
		}

		System.out.println("str page눈 " + strpage);

		int page = Integer.parseInt(strpage);
		searchVO.setPage(page);
		// 토탈 글의 개수 구하기
//		int total = dao.selectBoardTotCount();
		int total=0;
		if (btitle.equals("btitle") && bcontent.equals("")) {
			total=dao.selectBoardTotCount1(searchKeyword);
		}else if (btitle.equals("") && bcontent.equals("bcontent")) {
			total=dao.selectBoardTotCount2(searchKeyword);
		}else if (btitle.equals("btitle") && bcontent.equals("bcontent")) {
			total=dao.selectBoardTotCount3(searchKeyword);
		}else if (btitle.equals("") && bcontent.equals("")) {
			total=dao.selectBoardTotCount4(searchKeyword);
		} 
		
		
		
		System.out.println("total : " + total);
		searchVO.pageCalculate(total);

		System.out.println("totRow : " + total);
		System.out.println("clickpage : " + page);
		System.out.println("getPageStart : " + searchVO.getPageStart());
		System.out.println("getPageEnd : " + searchVO.getPageEnd());
		System.out.println("getTotPage : " + searchVO.getTotPage());
		System.out.println("getRowStart : " + searchVO.getRowStart());
		System.out.println("getRowEnd : " + searchVO.getRowEnd());

		int rowStart = searchVO.getRowStart();
		int rowEnd = searchVO.getRowEnd();
		
		
		ArrayList<BoardDto> list = null;
		
		if (btitle.equals("btitle") && bcontent.equals("")) {
//			list=dao.list(rowStart, rowEnd,searchKeyword,"1");
			model.addAttribute("list", dao.list(rowStart, rowEnd,searchKeyword,"1"));
		}else if (btitle.equals("") && bcontent.equals("bcontent")) {
//			list=dao.list(rowStart, rowEnd,searchKeyword,"2");
			model.addAttribute("list", dao.list(rowStart, rowEnd,searchKeyword,"2"));
		
		}else if (btitle.equals("btitle") && bcontent.equals("bcontent")) {
//			list=dao.list(rowStart, rowEnd,searchKeyword,"3");
			model.addAttribute("list", dao.list(rowStart, rowEnd,searchKeyword,"3"));
		}else if (btitle.equals("") && bcontent.equals("")) {
//			list=dao.list(rowStart, rowEnd,searchKeyword,"4");
			model.addAttribute("list", dao.list(rowStart, rowEnd,searchKeyword,"4"));
		} 	
				
		
		
		
		
		
		
//		model.addAttribute("list", list);
		model.addAttribute("totRowcnt", total);
		model.addAttribute("searchVO", searchVO);

		return "list";

	}

	// 글쓰기 폼
	@RequestMapping("/writerview")
	public String writerview(Model model) {

		return "writerview";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) throws IOException {
		System.out.println(request.getParameter("bname"));

		// toss
//		model.addAttribute("request", request);
//		bServiceInter = new BWriteService();
//		bServiceInter.execute(model);
//		String bname = req.getParameter("bname");
//		String btitle = request.getParameter("btitle");
//		String bcontent = request.getParameter("bcontent");
//		String fname = request.getFilesystemName("file");

		// upload code
		String attachPath="resources\\upload\\";
		String uploadPath=request.getSession().getServletContext().getRealPath("/");
		
		System.out.println("uploadPathhhh:"+uploadPath);
		//String path=uploadPath+attachPath;
//		String path="/sprj24mboardremypgsupload/src/main/webapp/resources/upload";
		String path="C:\\2023spring\\springwork1\\sprj24mboardremypgsupload\\src\\main\\webapp\\resources\\upload";
	
		MultipartRequest req=
				new MultipartRequest(request, path, 1024*1024*20, "utf-8",
						new DefaultFileRenamePolicy());//r같은 파일명을 정책대로 리네임 하겠다
		
		String bname = req.getParameter("bname");
		String btitle = req.getParameter("btitle");
		String bcontent = req.getParameter("bcontent");
		String fname = req.getFilesystemName("file");
		
		if(fname==null) {
			fname="";
		}
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.write(bname, btitle, bcontent,fname);

		return "redirect:list";
	}
	//download페이지
	@RequestMapping("/download")
	public String download(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception {
		System.out.println("download");

		String path=request.getParameter("p");
		String fname=request.getParameter("f");
		String bid=request.getParameter("bid");
		
		System.out.println(bid);

//		down 
				
//		header에 첨부라는 신호전달
		response.setHeader("Content-Disposition", "Attachment;filename="+URLEncoder.encode(fname, "utf-8"));
		
		
		
		String attachPath="resources\\upload\\";
		String realPath=request.getSession().getServletContext().getRealPath(attachPath)+"\\"+fname;
		
		
//		stream연결
		FileInputStream fin=new FileInputStream(realPath);
		ServletOutputStream sout= response.getOutputStream();
		
		byte[] buf=new byte[1024];
		int size =0;
		while((size=fin.read(buf,0,1024))!=-1) {
			sout.write(buf,0,size);;
		}
		fin.close();
		sout.close();
		
		
//		return "redirect:contentview?bid="+bid;
		return "contentview?bid="+bid;
//		return "list";
	}

	
	
	
	
	// contentview 페이지
	@RequestMapping("/contentview")
	public String contentview(HttpServletRequest request, Model model) {
		System.out.println("contentview");

//		model.addAttribute("request", request);
//		bServiceInter = new BContentviewService();
//		bServiceInter.execute(model);
//		

		String bid = request.getParameter("bid");
		IDao dao = sqlSession.getMapper(IDao.class);

		dao.uphit(bid);

		BoardDto dto = dao.contentview(bid);
		model.addAttribute("content_view", dto);

		return "contentview";
	}

	// contentupdate 페이지
	@RequestMapping("/contentupdate")
	public String contentupdate(HttpServletRequest request, Model model) {
		System.out.println("contentupdate");

//		model.addAttribute("request", request);
//		bServiceInter = new BContentupdateService();
//		bServiceInter.execute(model);

		String sbid = request.getParameter("bid");

		IDao dao = sqlSession.getMapper(IDao.class);
		BoardDto dto = dao.contentupdate(sbid);
		model.addAttribute("content_view", dto);

		return "contentupdate";
	}

	// modify 페이지
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify");

//		model.addAttribute("request", request);
//		bServiceInter= new BModifyService();
//		bServiceInter.execute(model);
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify(bid, bname, btitle, bcontent);

		return "redirect:list";
	}

	// delete 페이지
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete");

//		model.addAttribute("request", request);
//		bServiceInter= new BDeleteService();
//		bServiceInter.execute(model);

		String bid = request.getParameter("bid");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.delete(bid);

		return "redirect:list";
	}

	@RequestMapping("/replyview")
	public String replyview(HttpServletRequest request, Model model) {
		System.out.println("replyview");

//		model.addAttribute("request", request);
//		bServiceInter= new BReplyviewService();
//		bServiceInter.execute(model);
		IDao dao = sqlSession.getMapper(IDao.class);
		String bid = request.getParameter("bid");
		BoardDto dto = dao.replyview(bid);
		model.addAttribute("reply_view", dto);

		return "replyview";
	}

	// 답변달기 db에 insert
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply");

//		model.addAttribute("request", request);
//		bServiceInter= new BReplyService();
//		bServiceInter.execute(model);

		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bgroup = request.getParameter("bgroup");
		String bstep = request.getParameter("bstep");
		String bindent = request.getParameter("bindent");

		IDao dao = sqlSession.getMapper(IDao.class);

		dao.replyShape(bgroup, bstep);

		dao.reply(bid, bname, btitle, bcontent, bgroup, bstep, bindent);
		return "redirect:list";
	}
}
