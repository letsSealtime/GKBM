package kr.or.GKBM;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;









@Repository
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	SqlSession sqlSession;
	
	// emp.xml에서 가져온 전체페이지
	@Override
	public List<EmpDTO> selectEmpList() {		
		
		
		List<EmpDTO> result = sqlSession.selectList("mapper.emp.selectEmp");		
		System.out.println("result : " + result);
		return result;
	}

	// emp.xml에서 가져온 것으로 등록
		@Override
		public int addition(EmpDTO empDTO) {
			int dto = sqlSession.insert("mapper.emp.addition", empDTO);
			return dto;
		}
	
		// emp.xml에서 가져온 삭제
		@Override
		public int delete(EmpDTO empDTO) {
			int dto = sqlSession.delete("mapper.emp.delete", empDTO);
			return dto;
		}
		
		//내가 원하는거 조회
		@Override
		public List<EmpDTO> like(EmpDTO empDTO) {
			List<EmpDTO> dto = sqlSession.selectList("mapper.emp.selectBySkuId", empDTO);
			return dto;
		}
	

}
