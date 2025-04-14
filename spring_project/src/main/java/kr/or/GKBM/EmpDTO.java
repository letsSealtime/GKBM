package kr.or.GKBM;
import java.sql.Date;
//import java.util.List;

import lombok.Data;

// DTO : Data Transfer Object
// VO : Value Object
/*@Getter
@Setter
@ToString
@RequiredArgsConstructor // 생성자
@EqualsAndHashCode*/
@Data
public class EmpDTO {

	
	private int empno;		// 사원번호
	private String ename;	// 사원명
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal = -1;
	private Integer comm;
	private int deptno;
	
	private String type;
	private String keyword;
	
//	private List empnos;
	
	private int page = 1; // 현재 페이지
	private int viewCount = 10; // 페이지당 보여줄 수  countPerPage rowPerPage
	private int indexStart;
	private int indexEnd;
	
	// 이거 밑에있는거는 웹툰 연습
	String image; // 그림
	String title; // 제목
	String author; // 작가
	String detail; // 내용

	
}
