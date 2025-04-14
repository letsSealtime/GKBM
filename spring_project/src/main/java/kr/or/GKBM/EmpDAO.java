package kr.or.GKBM;

import java.util.List;



public interface EmpDAO {

	List<EmpDTO> selectEmpList(EmpDTO empDTO); 
	public EmpDTO selectOneEmp();
	public EmpDTO selectOneEmpno(int empno);
	public EmpDTO selectEmpno3(int empno);
	public EmpDTO selectEmpno4(EmpDTO empDTO);
	public int udpateEmp(EmpDTO empDTO);
	public int addition(EmpDTO empDTO);
	public int delete(EmpDTO empDTO);
	public List<EmpDTO> like(EmpDTO empDTO);
	public int totalEmp();
	
}
