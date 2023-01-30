package com.tech.sprj09.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tech.sprj09.db.DBCon;
import com.tech.sprj09.dto.BoardDto;

public class BoardDao {

//	public ArrayList<BoardDto> list() {
////오라클 접속해서 글 전체 가져오기
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
//		
//		try {
//			con=DBCon.getConnection();
////			String sql="SELECT BID,BNAME,BTITLE,BCONTENT,BDATE,"
////					+ "BHIT,BGROUP,BSTEP,BINDENT "
////					+ "FROM MBOARD";
//			String sql="SELECT BID,BNAME,BTITLE,BCONTENT,BDATE,BHIT,BGROUP,BSTEP,BINDENT FROM MBOARD order by bgroup desc, bstep asc";
//			
//			pstmt=con.prepareStatement(sql);
//			rs=pstmt.executeQuery();
////			rs.next();
////			System.out.println(rs.getString("btitle"));
//			while (rs.next()) {
//				//rs 에서 각 필드값을 하나씩 가져옴 boardDto에 담아줌 그게 리스트에 담김
//				int bid=rs.getInt("bid");
//				String bname=rs.getString("bname");
//				String btitle=rs.getString("btitle");
//				String bcontent=rs.getString("bcontent");
//				Timestamp bdate=rs.getTimestamp("bdate");
//				int bhit=rs.getInt("bhit");
//				int bgroup=rs.getInt("bgroup");
//				int bstep=rs.getInt("bstep");
//				int bindent=rs.getInt("bindent");
//			
//				//생성자를 통해 boarddto 에 전달하기
//				
//				BoardDto dto=new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
//				
//				dtos.add(dto);
//				
//				
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs!=null) rs.close();
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//			
//		return dtos;
//	}

//	public void write(String bname, String btitle, String bcontent) {
//
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		try {
//				con=DBCon.getConnection();
//				
////				String sql="INSERT INTO MBOARD(BID,BNAME,BTITLE,BCONTENT,"
////						+ "BDATE,BHIT,BGROUP,BSTEP,BINDENT) "
////						+ "VALUES(MBOARD_SEQ.NEXTVAL,"+bname+","+btitle+","+bcontent
////						+",SYSDATE,0,MBOARD_SEQ.CURRVAL,0,0)";
//				
//				
//				String sql="INSERT INTO MBOARD(BID,BNAME,BTITLE,BCONTENT,BDATE,BHIT,BGROUP,BSTEP,BINDENT) "
//						+ "VALUES(MBOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,0,MBOARD_SEQ.CURRVAL,0,0)";
//				
////			pstmt.executeUpdate(sql);
//			
//				pstmt=con.prepareStatement(sql);
//				pstmt.setString(1, bname);
//				pstmt.setString(2, btitle);
//				pstmt.setString(3, bcontent);
//				
//				int rn=pstmt.executeUpdate();
//				System.out.println(rn);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} 
//	}
//
//	public BoardDto contentupdate(String gbid) {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;	
//		BoardDto dto=null;
//		try {
//			con=DBCon.getConnection();
//			String sql="SELECT BID,BNAME,BTITLE,BCONTENT,BDATE,BHIT,BGROUP,BSTEP,BINDENT FROM MBOARD where bid=?";
//			
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(gbid));
//					
//			rs=pstmt.executeQuery();
//			rs.next();
//			//System.out.println(rs.getString("btitle"));
//			//BoardDto에 담아주기
//			//rs 에서 각 필드값을 하나씩 가져옴 boardDto에 담아줌 그게 리스트에 담김
//			int bid=rs.getInt("bid");
//			String bname=rs.getString("bname");
//			String btitle=rs.getString("btitle");
//			String bcontent=rs.getString("bcontent");
//			Timestamp bdate=rs.getTimestamp("bdate");
//			int bhit=rs.getInt("bhit");
//			int bgroup=rs.getInt("bgroup");
//			int bstep=rs.getInt("bstep");
//			int bindent=rs.getInt("bindent");
//			
//			dto=new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
//					
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs!=null) rs.close();
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		return dto;
//	}

//	public BoardDto contentview(String gbid, String gbgroup) {
//		
//		uphit(gbid);
//		
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;	
//		BoardDto dto=null;
//		try {
//			con=DBCon.getConnection();
//			String sql="SELECT BID,BNAME,BTITLE,BCONTENT,BDATE,BHIT,BGROUP,BSTEP,BINDENT FROM MBOARD where bid=?";
//			
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(gbid));
//					
//			rs=pstmt.executeQuery();
//			rs.next();
//			//System.out.println(rs.getString("btitle"));
//			//BoardDto에 담아주기
//			//rs 에서 각 필드값을 하나씩 가져옴 boardDto에 담아줌 그게 리스트에 담김
//			int bid=rs.getInt("bid");
//			String bname=rs.getString("bname");
//			String btitle=rs.getString("btitle");
//			String bcontent=rs.getString("bcontent");
//			Timestamp bdate=rs.getTimestamp("bdate");
//			int bhit=rs.getInt("bhit");
//			int bgroup=rs.getInt("bgroup");
//			int bstep=rs.getInt("bstep");
//			int bindent=rs.getInt("bindent");
//			
//			dto=new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
//					
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs!=null) rs.close();
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		return dto;
//	}

//	private void uphit(String gbid) {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		
//		try {
//			con=DBCon.getConnection();
//			String sql="update MBOARD set bhit=bhit+1 where bid=?";
//			
//			pstmt=con.prepareStatement(sql);
//			
//			pstmt.setInt(1, Integer.parseInt(gbid));
//			
//			int rn=pstmt.executeUpdate();
//			if(rn>0) {
//				System.out.println("조회수 증가");
//			}else {
//				System.out.println("조회수 안댐");
//				
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//		
//	}

//	public void modify(String bid, String bname, String btitle, String bcontent) {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		
//		try {
//			con=DBCon.getConnection();
//			String sql="update MBOARD set bname=?,btitle=?,bcontent=? where bid=?";
//			
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, bname);
//			pstmt.setString(2, btitle);
//			pstmt.setString(3, bcontent);
//			pstmt.setInt(4, Integer.parseInt(bid));
//			
//			pstmt.executeUpdate();
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}	
//		
//		
//		
//	}

//	public void delete(String bid, String bgroup) {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		
//		try {
//			
//			
//			con=DBCon.getConnection();
//			con.setAutoCommit(false);
//			
//		//int rn1=chekstep(bid,bgroup,bstep,con);
//			//int rn2=0;
//		
//			String sql="delete Mboard where bid=?";
//			
//			pstmt=con.prepareStatement(sql);
//		
//			pstmt.setInt(1, Integer.parseInt(bid));
////			
//			pstmt.executeUpdate();
//			
////			if (rn1>=0 && rn2>=1) {
////				con.commit();
////				System.out.println("커밋완료");
////			}else {
////				con.rollback();
////				System.out.println("롤붹");
////			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//		
//		
//		
//	}

	public BoardDto replyview(String gbid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		BoardDto dto=null;
		try {
			con=DBCon.getConnection();
			String sql="SELECT BID,BNAME,BTITLE,BCONTENT,BDATE,BHIT,BGROUP,BSTEP,BINDENT FROM MBOARD where bid=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(gbid));
					
			rs=pstmt.executeQuery();
			rs.next();
			//System.out.println(rs.getString("btitle"));
			//BoardDto에 담아주기
			//rs 에서 각 필드값을 하나씩 가져옴 boardDto에 담아줌 그게 리스트에 담김
			int bid=rs.getInt("bid");
			String bname=rs.getString("bname");
			String btitle=rs.getString("btitle");
			String bcontent=rs.getString("bcontent");
			Timestamp bdate=rs.getTimestamp("bdate");
			int bhit=rs.getInt("bhit");
			int bgroup=rs.getInt("bgroup");
			int bstep=rs.getInt("bstep");
			int bindent=rs.getInt("bindent");
			
			dto=new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
// 오라클 접속해서 덧글쓰기 
//	public void reply(String bid, String bgroup, String bstep, String bindent, String bname, String btitle,
//			String bcontent) {
//		
//		
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		try {
//				con=DBCon.getConnection();
//				//자동커밋 수동커밋으로
//				con.setAutoCommit(false);
//				//현재스텝보다 더큰 스텝이 있다면 1씩 증가 
//				int rn1=replyShape(bgroup,bstep,con);
//				int rn2=0;
//		
//				String sql="INSERT INTO MBOARD(BID,BNAME,BTITLE,BCONTENT,BDATE,BGROUP,BSTEP,BINDENT) "
//						+ "VALUES(MBOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,?,?,?)";
//	
//				pstmt=con.prepareStatement(sql);
//				pstmt.setString(1, bname);
//				pstmt.setString(2, btitle);
//				pstmt.setString(3, bcontent);
//				pstmt.setInt(4, Integer.parseInt(bgroup));
//				pstmt.setInt(5, Integer.parseInt(bstep)+1);
//				pstmt.setInt(6, Integer.parseInt(bindent)+1);
//				
//		
//				
//				rn2=pstmt.executeUpdate();
//				System.out.println("rn2 는 : "+rn2);
//				
//				
//				if (rn1>=0 && rn2>=1) {
//					con.commit();
//					System.out.println("커밋완료");
//				}else {
//					con.rollback();
//					System.out.println("롤붹");
//				}
//				
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//	}

//	private int replyShape(String bgroup, String bstep,Connection con) {
//		//현재스텝보다 더큰 스텝이 있다면 1씩 증가 
//		
//		PreparedStatement pstmt=null;
//		
//		int rn1=0;
//		
//		try {
//			
//			String sql="update mboard set bstep=bstep+1 where bgroup=? and bstep>?";
//			
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(bgroup));
//			pstmt.setInt(2, Integer.parseInt(bstep));
//			
//			
//			rn1=pstmt.executeUpdate();
//			
//			System.out.println("rn1 은? : "+rn1);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return rn1;
//	}

	

}
