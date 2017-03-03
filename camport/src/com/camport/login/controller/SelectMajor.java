
package com.camport.login.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.camport.admin.model.DTO.AdminDTO;
import com.camport.login.model.DAO.LoginDAO;
import com.camport.login.model.DTO.LoginDTO;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class SelectMajor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String univSeq = request.getParameter("universe");
		String colSeq = request.getParameter("collage");

		//System.out.println(univSeq);
		//System.out.println(colSeq);
		LoginDAO udao = new LoginDAO();
		ArrayList<LoginDTO> list = udao.list();

		
		
		// 단과대학목록 호출
		if (univSeq != null && univSeq.length() != 0) {
			LoginDAO cdao = new LoginDAO();
			ArrayList<LoginDTO> clist = cdao.clist(univSeq);

			// request.setAttribute("clist", clist);

			try {
				JSONArray jArray = new JSONArray();// 배열이 필요할때
				for (int i = 0; i < clist.size(); i++)// 배열
				{
					JSONObject sObject = new JSONObject();// 배열 내에 들어갈 json
					sObject.put("colName", clist.get(i).getColName());
					sObject.put("colSeq", clist.get(i).getColSeq());

					jArray.add(sObject);
				}

				//System.out.println(jArray.toString());

				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jArray.toString());

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		
		//전공 목록 호출
		if (colSeq != null && colSeq.length() != 0) {
			// if(!univSeq.isEmpty()){
			LoginDAO mdao = new LoginDAO();
			ArrayList<LoginDTO> mlist = mdao.mlist(colSeq);

			try {
				JSONArray jArray = new JSONArray();// 배열이 필요할때
				for (int i = 0; i < mlist.size(); i++)// 배열
				{
					JSONObject sObject = new JSONObject();// 배열 내에 들어갈 json
					sObject.put("majorName", mlist.get(i).getMajorName());
					sObject.put("majorSeq", mlist.get(i).getMajorSeq());

					jArray.add(sObject);
				}

				//System.out.println(jArray.toString());

				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jArray.toString());

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		// System.out.println(list.size());
		// System.out.println(clist.size());
		// System.out.println(mlist.size());

	}

}
