package kr.or.GKBM;

import java.io.IOException;
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













@Controller
public class EmpController {
	@Autowired
	EmpDAO empdao;

	
//	// 테이블 전체리스트
//	@RequestMapping(value = "/emp5", method = { RequestMethod.GET, RequestMethod.POST })
//	public String selectEmpList(@ModelAttribute EmpDTO dto, Model model, HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//
//		System.out.println(dto);
//		
//		List<EmpDTO> list = empdao.selectEmpList();
//
//		
//		model.addAttribute("list", list);
//		model.addAttribute("dto", dto);
//
//
//		return "emp";
//	}
	// 테이블 전체리스트
	@RequestMapping(value = "/emp5", method = { RequestMethod.GET, RequestMethod.POST })
	public String selectEmpList(@ModelAttribute EmpDTO dto, Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		System.out.println(dto);
		
		List<EmpDTO> list = empdao.selectEmpList();

		
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);


		return "emp";
	}

	// dao에서 가져온 추가
		@RequestMapping(value = "/p_sku", method = { RequestMethod.GET, RequestMethod.POST })
		public String addition1(@ModelAttribute EmpDTO empDTO) {
			System.out.println(empDTO);
			int select20 = empdao.addition(empDTO);

			return "redirect:emp5";
		}
		
		// dao에서 가져온 삭제
		@RequestMapping(value = "/p_skuDelete", method = { RequestMethod.GET, RequestMethod.POST })
		public String delete1(HttpServletRequest request) {
			String[] skuIds = request.getParameterValues("sku_id");

			if (skuIds != null) {
				for (String idStr : skuIds) {
					int id = Integer.parseInt(idStr);
					EmpDTO delDto = new EmpDTO();
					delDto.setSku_id(id);
					empdao.delete(delDto); 
				}
			}
			return "redirect:emp5";
		}

		// sku_code로 조회
		@RequestMapping(value = "/searchBySkuCode", method = { RequestMethod.GET, RequestMethod.POST })
		public String searchBySkuCode(@ModelAttribute EmpDTO empDTO, Model model) {
		    List<EmpDTO> list = empdao.like(empDTO);
		    model.addAttribute("list", list);
		    model.addAttribute("dto", empDTO);
		    
		    return "emp"; // 기존 JSP로 리다이렉트
		}
		

}
