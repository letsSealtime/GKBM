package kr.or.GKBM.vendor;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class VendorDTO {

	private Integer c_c;
	private String c_n;
	private String c_m;
	private String c_p;
	private String c_a;
	private Integer c_i;
	private List check = new ArrayList();

}
