package com.camport.communication.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.camport.communication.model.DTO.CommunicationBoardDTO;
import com.camport.communication.model.DTO.SearchDTO;

import Util.DBUtil;

public class CommunicationBoardDAO {
	private Connection conn = null;

	public CommunicationBoardDAO() {
		conn = DBUtil.open();
	}

	// (사용자) 게시판 글 쓰기
	public int communicationAdd(CommunicationBoardDTO dto) {

		try {

			String sql = "INSERT INTO COMMUNICATION_BOARD(COMM_NAME,COMM_CONTENT,COMM_FILENAME,COMM_ORGFILENAME,USER_ID) VALUES(?,?,?,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getCommName());
			stat.setString(2, dto.getCommContent());
			stat.setString(3, dto.getCommFileName());
			stat.setString(4, dto.getCommOrgFileName());
			stat.setString(5, dto.getUserId());
			return stat.executeUpdate();// 글쓰기

		} catch (Exception e) {

		}
		return 0;
	}

	// list불러오기(사용자용)
	public ArrayList<CommunicationBoardDTO> communicationList(SearchDTO sdto) {

		try {
			String where = "";
			if (sdto.isSearch()) {
				where = String.format("AND COMM_NAME  LIKE '%%%s%%' OR COMM_CONTENT LIKE '%%%s%%'", sdto.getWord(),
						sdto.getWord());
			}
			String sql = "SELECT COMM_BOARD_SEQ,COMM_NAME,COMM_CONTENT,COMM_REGDATE,COMM_FILENAME,COMM_ORGFILENAME,USER_ID FROM COMMUNICATION_BOARD WHERE COMM_VIEW = 'y'"
					+ where + " ORDER BY COMM_BOARD_SEQ DESC  LIMIT ?, 10";

			
			PreparedStatement stat = conn.prepareStatement(sql);

			stat.setInt(1, sdto.getStart() - 1);
			ResultSet rs = stat.executeQuery();

			ArrayList<CommunicationBoardDTO> list = new ArrayList<CommunicationBoardDTO>();
			// rs -> list 복사
			while (rs.next()) {
				// 레코드 1개 -> BoardDTO 1개
				CommunicationBoardDTO dto = new CommunicationBoardDTO();
				dto.setCommBoardSeq(rs.getString("COMM_BOARD_SEQ"));
				dto.setCommName(rs.getString("COMM_NAME"));
				dto.setCommContent(rs.getString("COMM_CONTENT"));
				dto.setUserId(rs.getString("USER_ID"));
				// dto.setCommRegdate(rs.getString("COMM_REGDATE").substring(0,19));
				dto.setCommRegdate(rs.getString("COMM_REGDATE").substring(0, 10));
				list.add(dto);
			}
			return list;

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		return null;
	}

	// list불러오기(관리자용)
	public ArrayList<CommunicationBoardDTO> communicationAdminList(SearchDTO sdto) {

		try {
			// 보이기/안보이기 설정 값 가져옴
			/*
			 * String yn = "WHERE COMM_VIEW='y'"; if (sdto.getYn().equals("y"))
			 * { yn= "WHERE COMM_VIEW='y'"; } else if (sdto.getYn().equals("n"))
			 * { yn= "WHERE COMM_VIEW='n'";
			 * 
			 * } else { yn= "";
			 * 
			 * };
			 */
			String where = "";
			if (sdto.isSearch()) {
				where = String.format("WHERE COMM_NAME  LIKE '%%%s%%' OR COMM_CONTENT LIKE '%%%s%%'", sdto.getWord(),
						sdto.getWord());
				/*
				 * where = String.
				 * format("AND COMM_NAME  LIKE '%%%s%%' OR COMM_CONTENT LIKE '%%%s%%'"
				 * , sdto.getWord(), sdto.getWord());
				 */ }
			String sql = "SELECT COMM_BOARD_SEQ,COMM_NAME,COMM_CONTENT,COMM_VIEW,COMM_REGDATE,COMM_FILENAME,COMM_ORGFILENAME,USER_ID FROM COMMUNICATION_BOARD "
					+ where + " ORDER BY COMM_BOARD_SEQ DESC  LIMIT ?, 10";

			PreparedStatement stat = conn.prepareStatement(sql);

			stat.setInt(1, sdto.getStart() - 1);
			ResultSet rs = stat.executeQuery();

			ArrayList<CommunicationBoardDTO> list = new ArrayList<CommunicationBoardDTO>();
			// rs -> list 복사
			while (rs.next()) {
				// 레코드 1개 -> BoardDTO 1개
				CommunicationBoardDTO dto = new CommunicationBoardDTO();
				dto.setCommBoardSeq(rs.getString("COMM_BOARD_SEQ"));
				dto.setCommName(rs.getString("COMM_NAME"));
				dto.setCommContent(rs.getString("COMM_CONTENT"));
				dto.setUserId(rs.getString("USER_ID"));
				// dto.setCommRegdate(rs.getString("COMM_REGDATE").substring(0,19));
				dto.setCommRegdate(rs.getString("COMM_REGDATE").substring(0, 10));
				dto.setCommView(rs.getString("COMM_VIEW"));
				dto.setCommFileName(rs.getString("COMM_FILENAME"));
				list.add(dto);
			}
			return list;

		} catch (Exception e) {

			System.out.println(e.toString());

		}

		return null;
	}

	// List 서블릿이 현재 게시판의 글의 총 갯수를 주세요.(사용자 comm_view='y')
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

	public int communicationEdit(String seq) {
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
	public int ynChange(String commBoardSeq, String yn) {
		// EditOk 서블릿이 수정할 모든 내용을 줄테니 수정해주세요..
		
		try {
			
			String sql = "UPDATE COMMUNICATION_BOARD SET COMM_VIEW = ? WHERE COMM_BOARD_SEQ = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setString(1, yn);
			stat.setString(2, commBoardSeq);
			
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		return 0;
	}
}
