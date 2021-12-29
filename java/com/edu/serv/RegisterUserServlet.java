package com.edu.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/html/RegisterUserServlet" })
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterUserServlet() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String memo = request.getParameter("memo");
		String registerBy = request.getParameter("registerBy");
		String event = request.getParameter("event");
		String[] hobbies = request.getParameterValues("hobby"); /* getParemaeterValues : 문자열을 여러개 담을 수 있는 파라미터*/
				
		StringBuffer sb = new StringBuffer();
		sb.append("<table border='1'>");
		sb.append("<tbody>"); 
		sb.append("<tr><th>아이디</th><td>"+id+"</td></tr>");
		sb.append("<tr><th>이메일</th><td>"+email+"</td></tr>");
		sb.append("<tr><th>메모</th><td>"+memo+"</td></tr>");
		sb.append("<tr><th>가입경로</th><td>"+registerBy+"</td></tr>");
		sb.append("<tr><th>취미</th><td>");
	
		for(String hobby : hobbies) {
			sb.append(hobby + " ");
		}
		sb.append("</td></tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		
		response.getWriter().println(sb.toString());

	}

}
