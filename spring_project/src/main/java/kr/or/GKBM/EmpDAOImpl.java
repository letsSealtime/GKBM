package kr.or.GKBM;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	SqlSession sqlSession;
	
	// emp.xml에서 가져온 테이블리스트
	@Override
	public List<EmpDTO> selectEmpList(EmpDTO empDTO) {
		
		int page = empDTO.getPage();
		int viewCount = empDTO.getViewCount();
		int indexStart = (viewCount * (page-1)) + 1;
		int indexEnd = page * viewCount;
		empDTO.setIndexStart(indexStart);
		empDTO.setIndexEnd(indexEnd);
		
		// 이건 전체페이지
//		List<EmpDTO> result = sqlSession.selectList("mapper.emp.selectEmp");
		List<EmpDTO> result = sqlSession.selectList("mapper.emp.page.selectPageEmp",empDTO);
		System.out.println("result : " + result);
		return result;
	}
	
	@Override
	public EmpDTO selectOneEmp() {
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectOneEmp");
		System.out.println("dto : " + dto);
		return dto;
	}
	
	@Override
	public EmpDTO selectOneEmpno(int empno) {
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectEmpno", empno);
		System.out.println("dto : " + dto);
		return dto;
	}
	
	@Override
	public EmpDTO selectEmpno3(int empno) {
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectEmpno3", empno);
		System.out.println("dto : " + dto);
		return dto;
	}
	
	@Override
	public EmpDTO selectEmpno4(EmpDTO empDTO) {
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectEmpno3", empDTO);
		System.out.println("dto : " + dto);
		return dto;
	}
	// emp.xml에서 가져온 수정을위한 업데이트
	@Override
	public int udpateEmp(EmpDTO empDTO) {
		int countUpdate = sqlSession.update("mapper.emp.udpateEmp", empDTO);
		return countUpdate;
	}
	// emp.xml에서 가져온 추가
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
	
	//검색
	@Override
	public List<EmpDTO> like(EmpDTO empDTO) {
		List<EmpDTO> dto = sqlSession.selectList("mapper.emp.dynamic.like", empDTO);
		return dto;
	}
	
	
	
	
	void getSeq() {
	int seq = 	sqlSession.selectOne("mapper.emp.getSeq");
	EmpDTO dto = new EmpDTO();
	dto.setEmpno(seq);
	dto.setEname("임의");
	// insert에 보내서 테이블 a에서 seq 사용
	// insert에 보내서 테이블 b에서 seq 사용
	}
	
	
	
		@Override
		public int totalEmp() {			
			int result = sqlSession.selectOne("mapper.emp.page.totalEmp");
			System.out.println("count(*) : " + result);
			return result;
		}

}
