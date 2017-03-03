package com.camport.communication.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.camport.communication.model.DAO.CommentDAO;
import com.camport.communication.model.DTO.CommentDTO;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class CommentList extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String commBoardSeq = request.getParameter("commBoardSeq");
		

		//System.out.println(commBoardSeq);
		//System.out.println(cntComment);

		CommentDAO dao = new CommentDAO();
		ArrayList<CommentDTO> commentlist = dao.commList(commBoardSeq);

		
		
		try {
			JSONArray jArray = new JSONArray();// 배열이 필요할때
			for (int i = 0; i < commentlist.size(); i++)// 배열
			{
				JSONObject sObject = new JSONObject();// 배열 내에 들어갈 json
				sObject.put("commentContent", commentlist.get(i).getCommentContent());
				sObject.put("commentRegdate", commentlist.get(i).getCommentRegdate());
				sObject.put("userId", commentlist.get(i).getUserId());
				sObject.put("adminId", commentlist.get(i).getAdminId());
				sObject.put("commentFile", commentlist.get(i).getCommentFileName());
				sObject.put("commentOrgFile", commentlist.get(i).getCommentOrgFileName());
				sObject.put("commentSeq", commentlist.get(i).getCommentSeq());
				
				
				jArray.add(sObject);
			}

				//System.out.println(jArray.toString());
			
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray.toString());

		} catch (JSONException e) {
			e.printStackTrace();
		}


	}

}
