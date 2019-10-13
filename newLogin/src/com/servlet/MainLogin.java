package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import passEnc.PasswordEnc;
import valid.ValidationHere;

/**
 * Servlet implementation class MainLogin
 */
@WebServlet("/MainLogin")
public class MainLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recpage = request.getRequestURI();
		response.setContentType("text/html");
		PrintWriter ptr = response.getWriter();
		ValidationHere v = new ValidationHere();
		if(recpage.equals("/newLogin/Done"))
		{
			String username1= request.getParameter("username");
			String password = request.getParameter("pass");
			
			boolean canyou = v.validLogin(username1, password);
			
			if(canyou)
			{			
				HttpSession session = request.getSession(true);
				RequestDispatcher rd = request.getRequestDispatcher("NewFile.html");
				rd.forward(request, response);
			}
		}
		if(recpage.equals("/newLogin/reg"))
		{
			PasswordEnc b = new PasswordEnc();
			String username1= request.getParameter("username");
			String password = request.getParameter("pass");
			String newPassword = b.enc(password);
			boolean registerAccount = v.register(username1, newPassword);
			
			if(registerAccount)
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
				
			}
			else
			{
				
			}
			
		}
		
	}

}
