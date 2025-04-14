package kr.or.GKBM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EmpController {
	@Autowired
	EmpDAO empdao;

	@RequestMapping(value = "/emp")
	public ModelAndView listEmp() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("emp");

		return mav;

	}

	@RequestMapping("/addwebtoon.do")
	public ModelAndView practiceForm() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("addwebtoon");

		return mav;
	}

	// 추가누르면 이동
	@RequestMapping(value = "/addwebtoon.do2", method = RequestMethod.GET)
	public ModelAndView submitForm() {
		return new ModelAndView("addwebtoon");
	}

	// 웹툰 내가 등록할때 쓰이는 입력하는거 리스트
	private List<EmpDTO> webtoonList = new ArrayList<EmpDTO>();

	@RequestMapping(value = "/addwebtoon.do", method = RequestMethod.POST)
	public String addwebtoon(EmpDTO dto, Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		webtoonList.add(dto); // 리스트에 웹툰 정보 추가
		model.addAttribute("webtoonList", webtoonList); // 리스트를 모델에 추가
		return "emp"; // 다 쓴 걸 처음 페이지로 보냄
	}

//	 private List<EmpDTO> webtoonList1 = new ArrayList<EmpDTO>();
//	 @RequestMapping(value = "/emp", method = RequestMethod.POST)
//	    public String addwebtoon1(EmpDTO dto1, Model model1, HttpServletRequest request, HttpServletResponse response)
//	            throws ServletException, IOException {
//	        request.setCharacterEncoding("utf-8");
//	        response.setContentType("text/html; charset=utf-8");
//
//	        webtoonList.add(dto1); // 리스트에 웹툰 정보 추가
//	        model1.addAttribute("webtoonList1", webtoonList1); // 리스트를 모델에 추가
//	        return "emp"; // 다 쓴 걸 처음 페이지로 보냄
//	    }

	@RequestMapping(value = "/emp2", method = { RequestMethod.GET, RequestMethod.POST })
	public String empOne(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		EmpDTO select = empdao.selectOneEmp();
		model.addAttribute("select", select);
//	        System.out.println(select);

		return "emp";

	}

	@RequestMapping(value = "/emp3", method = { RequestMethod.GET, RequestMethod.POST })
	public String empOne1(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		EmpDTO select1 = empdao.selectOneEmpno(7839);
		model.addAttribute("select1", select1);
		System.out.println(select1);

		return "emp";

	}

	// int로 내가 숫자입력한거 7902쓰는방법
	@RequestMapping(value = "/emp4", method = { RequestMethod.GET, RequestMethod.POST })
	public String emp4(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		EmpDTO select2 = empdao.selectEmpno3(7902);
		model.addAttribute("select2", select2);
		System.out.println(select2);

		return "emp";

	}

	// 테이블 전체리스트
	@RequestMapping(value = "/emp5", method = { RequestMethod.GET, RequestMethod.POST })
	public String selectEmpList(@ModelAttribute EmpDTO dto, Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		System.out.println(dto);
		
//		int page = 1;
//		String strPage = request.getParameter("page");
//		if(strPage != null) {
//			page = Integer.parseInt(strPage);
//		}
//		
//		int viewCount = 3;
//		dto.setPage(page);
//		dto.setViewCount(viewCount);
		
		List<EmpDTO> list = empdao.selectEmpList(dto);
		System.out.println("list.size:" + list.size());
		int count = empdao.totalEmp();
		System.out.println("count :" + count);
		
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		model.addAttribute("count", count);

		return "emp";
	}

	// emp99.jsp연결이랑 DAO에 selectEmpno4에 것을 쓰기
	@RequestMapping(value = "/emp99", method = { RequestMethod.GET, RequestMethod.POST })
	public String empOne99(@ModelAttribute EmpDTO empDTO, Model model) {

		EmpDTO select10 = empdao.selectEmpno4(empDTO);
		System.out.println("select10" + select10);
		model.addAttribute("select10", select10);

		return "emp99";

	}

	@RequestMapping(value = "/emp00", method = { RequestMethod.GET, RequestMethod.POST })
	public String empOne00(@ModelAttribute EmpDTO empDTO, Model model) {

		EmpDTO select10 = empdao.selectEmpno4(empDTO);
		System.out.println("select10" + select10);
		model.addAttribute("select10", select10);

		return "emp00";

	}

	// 수정을위한 업데이트
	@RequestMapping(value = "/emp6", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyEmp2(@ModelAttribute EmpDTO empDTO) {
		// 실제 업데이트
		// emp00에 있는거 잘왔는지 확인
		System.out.println(empDTO);
		int select20 = empdao.udpateEmp(empDTO);
		System.out.println("select20" + select20);

		// 전체목록으로 리턴

		return "redirect:emp5";
	}

	// 테이블 추가하기위해 추가누르면 이동
	@RequestMapping(value = "addition3", method = RequestMethod.GET)
	public ModelAndView addition2() {
		return new ModelAndView("addition");
	}

	// dao에서 가져온 추가
	@RequestMapping(value = "/emp7", method = { RequestMethod.GET, RequestMethod.POST })
	public String addition1(@ModelAttribute EmpDTO empDTO) {
		System.out.println(empDTO);
		int select20 = empdao.addition(empDTO);

		return "redirect:emp5";
	}

	// dao에서 가져온 삭제
	@RequestMapping(value = "/emp8", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete1(@ModelAttribute EmpDTO empDTO) {
		System.out.println("emp1 : " + empDTO);
		int select30 = empdao.delete(empDTO);

		return "redirect:emp5";
	}

	// 검색
	@RequestMapping(value = "/emp9", method = { RequestMethod.GET, RequestMethod.POST })
	public String like(Model model, @ModelAttribute EmpDTO empDTO) {
		System.out.println("emp1 : " + empDTO);

		if ("ename".equals(empDTO.getType())) {
			empDTO.setEname(empDTO.getKeyword());
		} else if (empDTO.getType() != null && empDTO.getType().equals("sal")) {
			try {
				int sal = Integer.parseInt(empDTO.getKeyword());
				empDTO.setSal(sal);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<EmpDTO> list = empdao.like(empDTO);
		model.addAttribute("list", list);

		return "emp";
	}

}
