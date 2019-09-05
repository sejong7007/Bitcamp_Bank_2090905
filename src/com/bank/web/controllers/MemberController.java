package com.bank.web.controllers;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constant;
import com.bank.web.services.MemberService;
import com.bank.web.serviecimpls.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		
		switch(request.getParameter("action")) {
		case "move" : 
			request.getRequestDispatcher
			(String.format(Constant.VIEW_PATH,
					"customer", 
					request.getParameter("dest")))
			.forward(request, response);
			break;
		
		case "join" : 
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			param.setId(id);
			param.setPw(pw);
			param.setName(name);
			param.setSsn(ssn);
			param.setCredit(credit);
			
			System.out.println(param);
			
			service.customerJoin(param);
			
			request.getRequestDispatcher
			(String.format(Constant.VIEW_PATH,
					"customer", 
					request.getParameter("dest")))
			.forward(request, response);
			break;
		
		case "login" : 
			System.out.println("로그인 서비스 진입 아이디"+request.getParameter("id") +"비번"+request.getParameter("pw"));
			
			param.setId(request.getParameter("id"));
			param.setPw(request.getParameter("pw"));
			
			CustomerBean cust = service.login(param);
			
			if(param.getId().equals(cust.getId())&&param.getPw().equals(cust.getPw())) {
				request.setAttribute("customer", cust);
				request.getRequestDispatcher
				
				(String.format(Constant.VIEW_PATH,
						"customer", 
						request.getParameter("dest")))
				.forward(request, response);
			}else {
				
				System.out.println(cust.toString());
				request.setAttribute("customer", cust);
				request.getRequestDispatcher
				
				(String.format(Constant.VIEW_PATH,
						"customer", 
						"login"))
				.forward(request, response);
			}
			
			
			
			break;
			
		case "existId":
			break;
			
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
