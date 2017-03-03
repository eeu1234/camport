package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.project.DTO.ReportBoardDTO;
import com.project.DTO.ReportBoardFileDTO;
import com.project.DTO.ReportCommentDTO;
import com.project.DTO.SearchDTO;

import Util.DBUtil;

public class ReportBoardDAO {

   private static Connection conn = null;
   
   public ReportBoardDAO() {
      conn = DBUtil.open();
   }

   //게시판 리스트 목록 보기
   /*public ArrayList<ReportBoardDTO> list() {
      
      try {
         
         String sql = "SELECT REPORTBOARD_SEQ, REPORTBOARD_NAME, USER_ID, REPORTBOARD_REGDATE, REPORTBOARD_POINT, REPORTBOARD_READCOUNT, REPORTBOARD_DOWNCOUNT FROM REPORT_BOARD ORDER BY REPORTBOARD_SEQ DESC";
         
         PreparedStatement stat = conn.prepareStatement(sql);
         
         ResultSet rs = stat.executeQuery();
         
         ArrayList<ReportBoardDTO> list = new ArrayList<ReportBoardDTO>();
         
         while (rs.next())   {
            ReportBoardDTO dto = new ReportBoardDTO();
            dto.setReportBoardSeq(rs.getInt("REPORTBOARD_SEQ"));
            dto.setReportBoardName(rs.getString("REPORTBOARD_NAME"));
            dto.setUserId(rs.getString("USER_ID"));
            dto.setReportBoardRegdate(rs.getString("REPORTBOARD_REGDATE"));
            dto.setReportBoardPoint(rs.getInt("REPORTBOARD_POINT"));
            dto.setReportBoardReadcount(rs.getInt("REPORTBOARD_READCOUNT"));
            dto.setReportBoardDowncount(rs.getInt("REPORTBOARD_DOWNCOUNT"));
            list.add(dto);
         }
         
         return list;
         
      } catch (Exception e) {

         System.out.println(e.toString());
         
      }
      
      return null;
   }*/

   
   //View - 게시글 선택하여 상세정보
   public ReportBoardDTO get(String reportBoardSeq) {   
      
      try {
         
         String sql = "SELECT REPORTBOARD_SEQ, REPORTBOARD_DOWNCOUNT, USER_ID, PW, REPORTBOARD_READCOUNT, REPORTBOARD_NAME, REPORTBOARD_CONTENT, REPORTBOARD_SUMMARY, REPORTBOARD_REGDATE, REPORTBOARD_POINT,REPORTBOARDFILENAME FROM REPORT_BOARD WHERE REPORTBOARD_SEQ = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1, reportBoardSeq);
         
         ResultSet rs = stat.executeQuery();
         
         if (rs.next()) {
         
            ReportBoardDTO dto = new ReportBoardDTO();
            
            dto.setReportBoardSeq(rs.getInt("REPORTBOARD_SEQ"));
            dto.setReportBoardDowncount(rs.getInt("REPORTBOARD_DOWNCOUNT"));
            dto.setUserId(rs.getString("USER_ID"));
            dto.setPw(rs.getString("PW"));
            dto.setReportBoardReadcount(rs.getInt("REPORTBOARD_READCOUNT"));
            dto.setReportBoardName(rs.getString("REPORTBOARD_NAME"));
            dto.setReportBoardFileName(rs.getString("REPORTBOARDFILENAME"));
            dto.setReportBoardContent(rs.getString("REPORTBOARD_CONTENT"));
            dto.setReportBoardSummary(rs.getString("REPORTBOARD_SUMMARY"));
            dto.setReportBoardRegdate(rs.getString("REPORTBOARD_REGDATE"));
            dto.setReportBoardPoint(rs.getInt("REPORTBOARD_POINT"));
               
            return dto;
            
            //file 확장가 사이즈 옵션 미적용
         }
         
      } catch (Exception e) {
         
         System.out.println("get : " + e.toString());
         
      }
      return null;
   }

   //View 서블릿이 글번호 줄테니 조회수 +1 해달라고 요청
   public void addReadCount(int reportBoardSeq) {

      try {

         String sql = "UPDATE REPORT_BOARD SET REPORTBOARD_READCOUNT = REPORTBOARD_READCOUNT + 1 WHERE REPORTBOARD_SEQ = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setInt(1, reportBoardSeq);
         
         stat.executeUpdate();

      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
   }
   
   //AddOk 
   /*public int add(ReportBoardDTO dto, ReportBoardFileDTO fdto) {
      
      try {
         int result = 0;
         
         String sql = "INSERT INTO REPORT_BOARD (REPORTBOARD_SEQ, REPORTBOARD_NAME, REPORTBOARD_CONTENT, REPORTBOARD_SUMMARY, REPORTBOARD_POINT, COLLAGE_SEQ, USER_ID, RULE_SEQ, PW, REPORTBOARDFILENAME, REPORTBOARDFILEORGNAME, THREAD, DEPTH FROM REPORT_BOARD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         //reportBoardFileName reportBoardFileOrgname thread depth
         //System.out.println(sql);
         //System.out.println(dto.getCollageSeq());
         PreparedStatement stat = conn.prepareStatement(sql);
         System.out.println(sql);
         stat.setInt(1, dto.getReportBoardSeq());
         //System.out.println(dto.getReportBoardSeq());
         stat.setString(2, dto.getReportBoardName());
         stat.setString(3, dto.getReportBoardContent());
         stat.setString(4, dto.getReportBoardSummary());
         //REPORTBOARD_POINT, COLLAGE_SEQ, USER_ID, RULE_SEQ, PW
         stat.setInt(5, dto.getReportBoardPoint());
         stat.setInt(6, dto.getCollageSeq());
         stat.setString(7, dto.getUserId());
         stat.setInt(8, dto.getRuleSeq());
         stat.setString(9, dto.getPw());
         //reportBoardFileName reportBoardFileOrgname thread depth
         stat.setString(10, dto.getReportBoardFileName());
         stat.setString(11, dto.getReportBoardFileOrgname());
         stat.setInt(12, dto.getThread());
         stat.setInt(13, dto.getDepth());
         int result1 = stat.executeUpdate();
         System.out.println(result1);
         
         
         //select
         sql = "SELECT REPORTBOARD_SEQ, REPORTBOARD_NAME, REPORTBOARD_CONTENT, REPORTBOARD_SUMMARY, REPORTBOARD_REGDATE, REPORTBOARD_POINT, COLLAGE_SEQ, USER_ID, PW, REPORTBOARDFILENAME, REPORTBOARDFILEORGNAME, THREAD, DEPTH FROM REPORT_BOARD";
         //reportBoardFileName reportBoardFileOrgname thread depth
          PreparedStatement stat2 = conn.prepareStatement(sql);
         
         ResultSet rs2 = stat2.executeQuery();
         
         while(rs2.next()){
            rs2.getInt("reportBoardSeq");
            rs2.getString("reportBoardName");
            rs2.getString("reportBoardContent");
            rs2.getString("reportBoardSummary");
            rs2.getString("reportBoardRegdate");
            rs2.getInt("reportBoardPoint");
            rs2.getInt("collageSeq");
            rs2.getString("userId");
            rs2.getString("pw");
            //추가 변수
            //reportBoardFileName reportBoardFileOrgname thread depth
            rs2.getString("reportBoardFileName");
            rs2.getString("reportBoardFileOrgname");
            rs2.getInt("thread");
            rs2.getInt("depth");
         }
            return result1;
               //System.out.println("2");   
         
         //SELECT
         
         sql = "INSERT INTO REPORTBOARD_FILE (REPORTBOARDFILE_SEQ, REPORTBOARDFILE_NAME, REPORTBOARDFILE_ORGNAME, REPORTBOARDFILE_SIZE, REPORTBOARDFILE_TYPE) VALUES(?, ?, ?, '80', 'jpg')";
         stat = conn.prepareStatement(sql);
                  
         stat.setInt(1, fdto.getReportBoardFileSeq());   //파일번호 PK
         System.out.println( fdto.getReportBoardFileSeq());
         stat.setString(2, fdto.getReportBoardFileName());   //파일이름
         System.out.println( fdto.getReportBoardFileName());
         stat.setString(3, fdto.getReportBoardFileOrgname());   //원본이름
         System.out.println(fdto.getReportBoardFileOrgname());
         //stat.setInt(4, fdto.getReportBoardSeq());   //게시판 번호(FK)
         
         int result3 = stat.executeUpdate();
         System.out.println("pass");
         //String sql2 = ""
         System.out.println(result3);
         return result3; //글쓰기
         
      } catch (Exception e) {
         
         System.out.println("add:" + e.toString());
         
      }
      
      return 0;*/

   //}//add
   
   public int add(ReportBoardDTO dto) {
      
      try {
         System.out.println(dto.getReportBoardFileName());
         String sql = "INSERT INTO REPORT_BOARD(REPORTBOARD_NAME, REPORTBOARD_CONTENT, REPORTBOARD_SUMMARY, REPORTBOARD_POINT,PW, REPORTBOARDFILENAME, REPORTBOARDFILEORGNAME,RULE_SEQ,THREAD,DEPTH,USER_ID) VALUES (?,?,?,?,?,?,?,'1',?,?,?)";
         System.out.println(sql);
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1, dto.getReportBoardName());
         stat.setString(2, dto.getReportBoardContent());
         stat.setString(3, dto.getReportBoardSummary());
         stat.setInt(4,dto.getReportBoardPoint());
         //stat.setInt(5, dto.getCollageSeq());
         stat.setString(5,dto.getPw());
         stat.setString(6,dto.getReportBoardFileName());
         stat.setString(7, dto.getReportBoardFileOrgname());
         stat.setInt(8,dto.getThread());
         stat.setInt(9, dto.getDepth());
         stat.setString(10, dto.getUserId());
         return stat.executeUpdate();
      } catch (Exception e) {
         System.out.println("add : " + e.toString());
      }
      
      
      
      
      return 0;
      
      
      
      
   }

   //테이블에서 조건을 만족하는 행의 개수를 반환하는 함수 COUNT(*)
   public boolean check(ReportBoardDTO dto) {
   
      try {

         //아래의 쿼리에서 최대값이 1이 나오는 이유가 뭔가요?
         //      -> 한마디 -> SEQ + ? -> PK
         String sql = "SELECT COUNT(*) AS CNT FROM REPORT_BOARD WHERE REPORTBOARD_SEQ = ? AND PW = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setInt(1, dto.getReportBoardSeq());
         stat.setString(2, dto.getPw());
         
         ResultSet rs = stat.executeQuery();
         
         if (rs.next()) {
            System.out.println("1");
            if (rs.getInt("cnt") == 1) {
               return true;
            }
         }
         

      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
      return false;
   }
   
   //DelOk 서블릿이 글번호를 줄테니 글을 삭제해주세요.
   public int del(ReportBoardDTO dto) {
      
      try {

         String sql = "DELETE FROM REPORTBOARD_FILE WHERE REPORTBOARD_SEQ = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setInt(1, dto.getReportBoardSeq());
         stat.executeUpdate();
         
         sql = "DELETE FROM REPORT_BOARD WHERE REPORTBOARD_SEQ = ?";
         stat = conn.prepareStatement(sql);
         stat.setInt(1, dto.getReportBoardSeq());
         
         return stat.executeUpdate();
         
      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
      return 0;
   }

   public int edit(ReportBoardDTO dto) {
      try {

         String sql = "UPDATE REPORT_BOARD SET REPORTBOARD_NAME = ?, REPORTBOARD_CONTENT = ?, REPORTBOARD_SUMMARY = ?, PW = ? WHERE REPORTBOARD_SEQ = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         
         //System.out.println("테스트");
         //REPORTBOARD_NAME / REPORTBOARD_CONTENT / REPORTBOARD_SUMMARY / PW
         //where -> REPORTBOARD_SEQ
         stat.setString(1, dto.getReportBoardName());
         stat.setString(2, dto.getReportBoardContent());
         stat.setString(3, dto.getReportBoardSummary());
         stat.setString(4, dto.getPw());
         stat.setInt(5, dto.getReportBoardSeq());
         
         return stat.executeUpdate();

      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
      return 0;
   }

   public ReportBoardDTO get(Integer reportBoardSeq) {
      
      try {
         String sql = "SELECT REPORTBOARD_SEQ, REPORTBOARD_NAME, REPORTBOARD_CONTENT, REPORTBOARD_SUMMARY, REPORTBOARD_REGDATE, REPORTBOARD_READCOUNT, REPORTBOARD_DOWNCOUNT, REPORTBOARD_POINT, COLLAGE_SEQ, USER_ID, RULE_SEQ, PW FROM REPORT_BOARD WHERE REPORTBOARD_SEQ = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setInt(1, reportBoardSeq);
         
         ResultSet rs = stat.executeQuery();
         
         if (rs.next()) {
            
            ReportBoardDTO dto = new ReportBoardDTO();
            dto.setReportBoardSeq(rs.getInt("reportBoardSeq"));
            dto.setReportBoardName(rs.getString("reportBoardName"));
            dto.setReportBoardContent(rs.getString("reportBoardContent"));
            dto.setReportBoardSummary(rs.getString("reportBoardSummary"));
            dto.setReportBoardRegdate(rs.getString("reportBoardRegdate"));
            dto.setReportBoardDowncount(rs.getInt("reportBoardDowncount"));
            dto.setReportBoardPoint(rs.getInt("reportBoardPoint"));
            dto.setCollageSeq(rs.getInt("collageSeq"));
            dto.setUserId(rs.getString("userId"));
            dto.setRuleSeq(rs.getInt("ruleSeq"));
            dto.setPw(rs.getString("pw"));
            
            return dto;
         }
                  
      } catch (Exception e) {

         System.out.println(e.toString());
         
      }
      
      return null;
   }

   



   //답변글의 a 규칙 실행
/*
   public void updateThread(int thread, int prevThread) {

      try {

         String sql = String.format("UPDATE REPORT_BOARD SET THREAD = THREAD - 1 WHERE THREAD > ? AND THREAD < ?");
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setInt(1, prevThread);
         stat.setInt(2, thread);
         stat.executeUpdate();

      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
   }
*/
   //List 서블릿이 현재 게시판의 글의 총 갯수를 주세요.
   public int getTotal(SearchDTO sdto) {

      try {

         String where = "";
         if (sdto.isSearch()) {
            where = String.format(" WHERE %s like '%%%s%%'"
                                          , sdto.getColumn()
                                          , sdto.getWord());
         }
         
         String sql = "SELECT COUNT(*) AS CNT FROM REPORT_BOARD" + where;
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

   public ArrayList<ReportBoardDTO> list(SearchDTO sdto) {

         try {

            String where = "";
            if (sdto.isSearch()) {
               
               where = String.format("AND REPORTBOARD_NAME LIKE '%%%s%%' OR REPORTBOARD_CONTENT LIKE '%%%s%%'",
                     sdto.getWord(), sdto.getWord());
               
               /*where = String.format("WHERE %s like '%%%s%%'"
                                             , sdto.getColumn()
                                             , sdto.getWord());*/
            }
            
         
            String sql = "SELECT REPORTBOARD_SEQ, REPORTBOARD_NAME, USER_ID, REPORTBOARD_REGDATE, REPORTBOARD_POINT, REPORTBOARD_READCOUNT, REPORTBOARD_DOWNCOUNT FROM REPORT_BOARD WHERE RULE_SEQ='1'"
                  + where + " ORDER BY REPORTBOARD_SEQ DESC LIMIT ?,10";
            
            
           
            
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, sdto.getStart()-1);
            ResultSet rs = stat.executeQuery();
            

            ArrayList<ReportBoardDTO> list = new ArrayList<ReportBoardDTO>();
            while (rs.next()) {
               ReportBoardDTO dto = new ReportBoardDTO();

               dto.setReportBoardSeq((rs.getInt("REPORTBOARD_SEQ")));
               dto.setReportBoardName(rs.getString("REPORTBOARD_NAME"));
               dto.setUserId(rs.getString("USER_ID"));
               dto.setReportBoardRegdate(rs.getString("REPORTBOARD_REGDATE"));
               dto.setReportBoardPoint(rs.getInt("REPORTBOARD_POINT"));
               dto.setReportBoardReadcount(rs.getInt("REPORTBOARD_READCOUNT"));
               dto.setReportBoardDowncount(rs.getInt("REPORTBOARD_DOWNCOUNT"));
              
             

               list.add(dto);
               
            }
            
            return list;

         } catch (Exception e) {
            System.out.println("hh"+e.toString());
         }

         return null;
      }

   public void addReportBoardReadcount(String reportBoardSeq) {

      try {

         String sql = "UPDATE REPORT_BOARD SET REPORTBOARD_READCOUNT = REPORTBOARD_READCOUNT + 1 WHERE REPORTBOARD_SEQ = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1, reportBoardSeq);
         
         stat.executeUpdate();

      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
   }

   public ArrayList<ReportCommentDTO> listComment(String reportBoardSeq) {
      
      try {

         String sql = "SELECT REPORTCOMMENT_SEQ, REPORTCOMMENT_CONTENT, REPORTCOMMENT_REGDATE, REPORTBOARD_SEQ, USER_ID, RULE_SEQ FROM REPORT_COMMENT WHERE REPORTBOARD_SEQ = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1, reportBoardSeq);
         
         ResultSet rs = stat.executeQuery();
         
         ArrayList<ReportCommentDTO> clist = new ArrayList<ReportCommentDTO>();
         
         while (rs.next()) {
            //레코드 1개 -> DTO 1개
            ReportCommentDTO dto = new ReportCommentDTO();
            /* 
               REPORTCOMMENT_SEQ      int
               REPORTCOMMENT_CONTENT      varchar
               REPORTCOMMENT_REGDATE      varchar
               REPORT_COMMENT_THREAD      int   
               REPORT_COMMENT_DEPTH      int
               REPORTBOARD_SEQ         int
               USER_ID            varchar
               RULE_SEQ         int 
            */
            dto.setReportCommentSeq(rs.getInt("REPORTCOMMENT_SEQ"));
            dto.setReportCommentContent(rs.getString("REPORTCOMMENT_CONTENT"));
            dto.setReportCommentRegdate(rs.getString("REPORTCOMMENT_REGDATE"));
            dto.setReportBoardSeq(rs.getInt("REPORTBOARD_SEQ"));
            dto.setUserId(rs.getString("USER_ID"));
            dto.setRuleSeq(rs.getInt("RULE_SEQ"));
            clist.add(dto);
            
         }
         
         return clist;

      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
      return null;
   }

   public int addComment(ReportCommentDTO cdto) {
      try {

         //댓글 추가
         String sql = "INSERT INTO REPORT_COMMENT (REPORTCOMMENT_SEQ, USER_ID, REPORTCOMMENT_CONTENT, REPORTBOARD_SEQ, RULE_SEQ) VALUES (?, ?, ?, ?, '2');";
         PreparedStatement stat = conn.prepareStatement(sql);
         
         stat.setInt(1, cdto.getReportCommentSeq());
         stat.setString(2, cdto.getUserId());
         stat.setString(3, cdto.getReportCommentContent());
         stat.setInt(4, cdto.getReportBoardSeq());
         //stat.setInt(5, cdto.getRuleSeq());
         
         int result = stat.executeUpdate();
         
         if (result > 0) {
            //댓글수 증가
            sql = "UPDATE REPORT_BOARD SET COMMENTCOUNT = COMMENTCOUNT + 1 WHERE REPORTBOARD_SEQ = ?";
            
            stat = conn.prepareStatement(sql);
            stat.setInt(1, cdto.getReportBoardSeq());
            stat.executeUpdate();
         }
         
         return result;         

      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
      return 0;
   }

   //DelCommentOk 서블릿이 댓글 번호를 줄테니 댓글 삭제해주세요..
   public int delComment(String reportCommentSeq, String reportBoardSeq) {
      
      try {

         String sql = "DELETE FROM REPORT_COMMENT WHERE REPORTCOMMENT_SEQ = ?";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1, reportCommentSeq);
         
         int result = stat.executeUpdate();
         
         sql = "UPDATE REPORT_BOARD SET COMMENTCOUNT = COMMENTCOUNT - 1 WHERE REPORTBOARD_SEQ = ?";
         stat = conn.prepareStatement(sql);
         stat.setString(1, reportBoardSeq);
         stat.executeUpdate();
         
         return result;

      } catch (Exception e) {

         System.out.println(e.toString());

      }
      
      return 0;
   }


}