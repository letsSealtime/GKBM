package kr.or.GKBM;

import java.util.List;



public interface EmpDAO {
	//테이블 리스트
	List<EmpDTO> selectEmpList(); 
	//등록
	public int addition(EmpDTO empDTO);
	//삭제
	public int delete(EmpDTO empDTO);
	//내가 원하는거 조회
	public List<EmpDTO> like(EmpDTO empDTO);
	
}
