package com.camport.login.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.login.model.DAO.LoginDAO;
import com.camport.login.model.DTO.LoginDTO;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDAO udao = new LoginDAO();
		ArrayList<LoginDTO> list = udao.list();

		

		// if(!univSeq.isEmpty()){
		LoginDAO mdao = new LoginDAO();
		ArrayList<LoginDTO> mlist = mdao.mlist("1");

		// System.out.println(list.size());
		// System.out.println(clist.size());
		// System.out.println(mlist.size());

		request.setAttribute("list", list);
		request.setAttribute("mlist", mlist);

		RequestDispatcher dispatcher =	 request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);

	}

}
