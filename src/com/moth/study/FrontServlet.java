package com.moth.study;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * forward는 하나의 요청과 응답객체를 유지한 채 작업이 이루어지지만 

redirect는 하나의 서블릿의 요청과 응답이 끝나면 새로운 요청과 응답이 시작되면서 작업이 끝남

forward는 하나의 요청과 응답객체를 사용하고 redirect는 여러개의 요청과 응답객체를 사용함

 */
/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            int diceValue = (int)(Math.random() * 6) + 1; 
            request.setAttribute("dice", diceValue);
            
            RequestDispatcher requestDispatehcer = request.getRequestDispatcher("/next");
            requestDispatehcer.forward(request, response);
    }

}
