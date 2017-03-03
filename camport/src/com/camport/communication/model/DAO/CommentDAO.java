package com.camport.communication.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.camport.communication.model.DTO.CommentDTO;
import com.camport.communication.model.DTO.CommunicationBoardDTO;
import com.camport.communication.model.DTO.SearchDTO;

import Util.DBUtil;

public class CommentDAO {
	private Connection conn = null;

	public CommentDAO() {
		conn = DBUtil.open();
	}

	public ArrayList<CommentDTO> commList(String boardSeq) {
		try {
			String sql = "SELECT COMMENT_SEQ,COMMENT_CONTENT,COMMENT_REGDATE,COMMENT_FILENAME,COMMENT_ORGFILENAME,COMM_BOARD_SEQ,USER_ID,ADMIN_ID  FROM COMMUNICATION_COMMENT WHERE COMM_BOARD_SEQ = ? ORDER BY COMMENT_SEQ ";
			
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, boardSeq);
			
			
			
			ResultSet rs = stat.executeQuery();
			

			ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();
			while (rs.next()) {
				
				CommentDTO dto = new CommentDTO();
				dto.setCommentSeq(rs.getString("COMMENT_SEQ"));
				dto.setCommentContent(rs.getString("COMMENT_CONTENT"));
				dto.setCommentRegdate(rs.getString("COMMENT_REGDATE"));
				dto.setCommentFileName(rs.getString("COMMENT_FILENAME"));
				dto.setCommentOrgFileName(rs.getString("COMMENT_ORGFILENAME"));
				dto.setCommBoardSeq(rs.getString("COMM_BOARD_SEQ"));
				dto.setUserId(rs.getString("USER_ID"));
				dto.setAdminId(rs.getString("ADMIN_ID"));
			
				list.add(dto);
			}
			
			
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return null;
	}

	// 코멘트 글 쓰기
	public int commAdd(CommentDTO dto) {

		try {
			
			String sql = "INSERT INTO COMMUNICATION_COMMENT (COMMENT_CONTENT,COMMENT_FILENAME,COMMENT_ORGFILENAME, COMM_BOARD_SEQ,USER_ID,ADMIN_ID) VALUES (?,?,?,?,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);

			/*System.out.println(dto.getUserId());
			System.out.println(dto.getAdminId());*/
			

			stat.setString(1, dto.getCommentContent());
			stat.setString(2, dto.getCommentFileName());
			stat.setString(3, dto.getCommentOrgFileName());
			stat.setString(4, dto.getCommBoardSeq());
			if(dto.getUserId().equals("admin")){
				stat.setString(5, "");
				stat.setString(6, dto.getAdminId());
			}else{
				
				stat.setString(5, dto.getUserId());
				stat.setString(6, "");
			}

			
			
			
			return stat.executeUpdate();// 글쓰기

		} catch (Exception e) {

		}
		return 0;
	}

	// List 서블릿이 현재 게시판의 글의 총 갯수를 주세요.
	public int getTotal(SearchDTO sdto) {

		try {

			String where = "";
			if (sdto.isSearch()) {
				where = String.format(" WHERE %s like '%%%s%%'", sdto.getColumn(), sdto.getWord());
			}

			String sql = "SELECT COUNT(*) AS CNT FROM COMMUNICATION_BOARD WHERE COMM_VIEW='y'";
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		return 0;
	}

	public int commEdit(String seq) {
		// EditOk 서블릿이 수정할 모든 내용을 줄테니 수정해주세요..

		try {

			String sql = "UPDATE COMMUNICATION_BOARD SET COMM_NAME = ?, COMM_VIEW = ? WHERE COMM_BOARD_SEQ = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, "블라인드 처리 되었습니다.");
			stat.setString(2, "n");
			stat.setString(3, seq);

			return stat.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		return 0;
	}

}
