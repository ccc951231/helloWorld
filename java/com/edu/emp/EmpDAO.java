package com.edu.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.emp.EmployeeVO;

public class EmpDAO extends DAO {
	//삭제
	public void deleteEmp(int eid) {
		String sql = "DELETE FROM emp_temp WHERE employee_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eid);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정.
	public void updateEmp(EmployeeVO vo) {
	 String sql = "update emp_temp set salary=?, job_id=?, email=? where employee_id=?"; //바꿀 값만 작성해주면 된다.
	 connect();
	 try {
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, vo.getSalary());
		psmt.setString(2, vo.getJobId());
		psmt.setString(3, vo.getEmail());
		psmt.setInt(4, vo.getEmployeeId());
		int r = psmt.executeUpdate();
		System.out.println(r + "건 변경.");
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();
	}
	
	}
	//한 건 입력.
	public void insertEmp(EmployeeVO vo) {
		String sql = "insert into emp_temp(employee_id, first_name, last_name, email, job_id, salary, hire_date)"
					+ "VALUES(employees_seq.nextval, ?, ?, ?, ?, ?, ?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getJobId());
			psmt.setInt(5, vo.getSalary());
			psmt.setString(6,  vo.getHireDate());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//전체 리스트.
	public List<EmployeeVO> getEmpList(){
		String sql = "select * from emp_temp order by 1";
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();{ 
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //위의 쿼리를 실행하겠다.
			
			while(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return empList;
	}
}
 	public EmployeeVO getEmployee(int eid) {
		String sql = "select * from emp_temp where employee_id=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  eid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
		
	}
}
