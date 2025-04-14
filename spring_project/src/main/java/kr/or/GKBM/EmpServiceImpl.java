package kr.or.GKBM;

import java.util.HashMap;
import java.util.Map;



public abstract class EmpServiceImpl implements EmpDAO{

	EmpDAO empDAO;
	
	void paging() {
		int page = 3;
		int viewCount = 10;
		
//		(10 * 2) + 1
//		(viewCount * 2) + 1
//		(viewCount * (3-1)) + 1
		int idxStart = (viewCount * (page-1)) + 1;
		int idxEnd = page * viewCount;
	}
	// 전체 글 개수
//	int total = empDAO.totalEmp();
//	
//	Map<String, Object> map = new HashMap();
//	map.put("list", list);
//	map.put ("total", total);
//	
//	return list;
	
}
