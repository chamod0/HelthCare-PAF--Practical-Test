package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoctorAPI
 */
@WebServlet("/DoctorAPI")
public class DoctorAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Doctor DoctorObj = new Doctor();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("name") != null) {

			String output = DoctorObj.insertDoctor(request.getParameter("name"),
					request.getParameter("Tel"),
					request.getParameter("Specialization"),
					request.getParameter("Hospital"),
					request.getParameter("Email"),
					request.getParameter("password"));

			response.getWriter().write(output);
			
			//doctor login checker

		} else if (request.getParameter("DoUsername") != null) {
			
			String DoUsername = request.getParameter("DoUsername");
			String Dopassword = request.getParameter("Dopassword");
			
			if (DoctorObj.logincheck(DoUsername, Dopassword)!="wrong credentials") {
				
			
				HttpSession session = request.getSession();
				session.setAttribute("DoUsername", DoUsername);
				
				session.setAttribute("details", DoctorObj.logincheck(DoUsername, Dopassword));
				
				response.sendRedirect("DoctorProfile.jsp");
				
				
			}else {
				
				response.sendRedirect("DoctorLogin.jsp");
			}
			
				
		} else {
//admin login checker

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username.equals("admin") && password.equals("admin")) {
				
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("AdminPanel.jsp");
				
			} else {
				
				response.sendRedirect("AdminLogin.jsp");
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = DoctorObj.updateDoctor(paras.get("hidDoctorIDSave").toString(), paras.get("name").toString(),
				paras.get("Tel").toString(), paras.get("Specialization").toString(), paras.get("Hospital").toString(),
				paras.get("Email").toString(), paras.get("password").toString());
		response.getWriter().write(output);

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = DoctorObj.deleteDoctor(paras.get("DoId").toString());
		response.getWriter().write(output);
	}

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {

				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

}
