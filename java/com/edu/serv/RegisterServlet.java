package com.edu.serv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;


@WebServlet("/RegisterServlet") //("/RegisterServlet")실행하기 위한 웹주소
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
       super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) //
		throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String fn = request.getParameter("first_name");
		String ln = request.getParameter("last_name");
		String em = request.getParameter("email");
		String ji = request.getParameter("job_id");
		String hd = request.getParameter("hire_date");
		String sa = request.getParameter("salary");
		
		
		EmpDAO dao = new EmpDAO();
		EmployeeVO vo = new EmployeeVO();
		vo.setEmail(em);
		vo.setFirstName(fn);
		vo.setHireDate(hd);
		vo.setJobId(ji);
		vo.setLastName(ln);
		vo.setSalary(Integer.parseInt(sa));
		
		dao.insertEmp(vo);
		response.getWriter().print("<h2>처리완료</h2>");
		
		/*dao.getEmpList();
		List<EmployeeVO> list = dao.getEmpList();
		
		for(EmployeeVO emp : list) {
			response.getWriter().print(emp);*/
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
