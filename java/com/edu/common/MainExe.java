package com.edu.common;

import java.util.List;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;

public class MainExe {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		
		//입력 값을 fn, ln, em, hd, ji, sa
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(209);
		vo.setFirstName("민수");
		vo.setLastName("김");
		vo.setEmail("ms@email.com");
		vo.setHireDate("2021-05-01");
		vo.setJobId("SA_MAN");	
		vo.setSalary(6000);
		
		dao.insertEmp(vo);
		dao.updateEmp(vo); //다건이므로 변수를 넣어 대입시킨다.
		dao.deleteEmp(209); //한건 삭제이므로 (id가 key)
		
		List<EmployeeVO> empList = dao.getEmpList();
		
		for(EmployeeVO emp : empList) //한건씩 받아오기 위해 반복문을 사용
		System.out.println(emp);
	}

}
