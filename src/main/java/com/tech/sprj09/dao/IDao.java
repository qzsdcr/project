package com.tech.sprj09.dao;

import java.util.ArrayList;

import com.tech.sprj09.dto.BoardDto;

public interface IDao {

	public ArrayList<BoardDto> list(int start ,int end, String sk, String selNum);
	//Arraylist 형식으로 열의 시작 값과 마지막 값 String 타입의 키워드와 타이틀 내용 검색구분을 위한 selNum를 받아서
	//selnum로 검색 구분을 한후 sk 키워드 값으로 PageVO를 통해 검색된 총 검색수의 시작과 끝을 받아서 list에 값을 리턴해준다
	public void write(String bname, String btitle, String bcontent, String fname);
	//Bcontroller 단에서 요청된 bname,btitle,bcontent의 파람값과 file의 파일명을 포함하여 mapper에 전달한다. 

	
	public BoardDto contentview(String bid);
	// list.jsp 에서 클릭된 bid 번호를 넘겨받아 contentviewer 포멧을 열고 그안에 값을 입력한다.

	public void uphit(String bid);
	//cotentview에 진입할때 받아욘 bid 넘버를 여기서도 받아서 hit 값을 +1 update 한다.
	
	
	public BoardDto contentupdate(String sbid);
	// contentview에서 가지고있는 bid 숫자를 다시 가지고와서 내용을 뿌려주면서 update 포멧으로 이동한다.
	
	
	public void modify(String bid, String bname, String btitle, String bcontent);
	// update 포멧에 입력된 값 각각 bid bname btitle bcontent의 값을 받아 update 한다. 
	
	
	public void delete(String bid);
	// bid 값을 받아 번호에 조회된 값을 db에서 삭제한다.
	public BoardDto replyview(String bid);
	//원글의 내용을 bid로 조회해서 가져와서 reply포멧에 뿌려준다.
	
	public void reply(String bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent);
	//원글의 bid bname btitle bcontent 와  bgroup bstep bindent 번호를 가져와서 입력을 한다.
	//이때 bgroup는 원글의 값을 유지하고 bstep과 bindent는 +1 증가한다.
	

	public void replyShape(String bgroup, String bstep);
	// bstep의 값을 + 증가시켜준다  

	public int selectBoardTotCount1(String searchKeyword);
   // 키워드에 작성된 내용이 btitle에서 비슷한 내용이있는지 검색한다.
	public int selectBoardTotCount2(String searchKeyword);
	// 키워드에 작성된 내용이 bcontent에서 비슷한 내용이있는지 검색한다.

	public int selectBoardTotCount3(String searchKeyword);
	// 키워드에 작성된 내용이 bcontent 또는 btitle 에서 비슷한 내용이있는지 검색한다.

	public int selectBoardTotCount4(String searchKeyword);
	// 아무것도 선택하지 않았을때에는 전체 숫자를 검색한다.


}
 