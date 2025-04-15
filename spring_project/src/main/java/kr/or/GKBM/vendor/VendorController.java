package kr.or.GKBM.vendor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VendorController {
	
	@RequestMapping("/vendor")
	public String vendorEnter() {
		return "vendor";
	}

}
