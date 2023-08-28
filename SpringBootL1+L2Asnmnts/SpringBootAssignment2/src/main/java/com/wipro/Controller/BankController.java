package com.wipro.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BankController {
	
	
	@RequestMapping(value="/branches",method = RequestMethod.GET)
	public String getBranches(ModelMap m) {
	List<String> l=new ArrayList<>();
	l.add("No.24/3 & 51, HDFC House, Kasturba Road, Bangalore - 560001");
	l.add("No.26, Ground Floor, Rakshakya Commercial Complex, Victoria Road, Shanthala Nagar, Bangalore - 560001");
	l.add("No. 548/D, 1st Floor, Maruthi Mansion, Chinmaya Mission Hospital Road, Indiranagar, Bangalore - 560038");
	l.add("No. 7/19, Palace Cross Road, Vasanth Nagar, Bangalore - 560001");
	l.add("No. 755, Shree Krishna Temple Road, Cmh Road, Bangalore - 560038");
	l.add("No.25/1, Shankar Narayana Building, M G Road, Bangalore - 56000");
	l.add("No. 03/01, Ground Floor, Ward No.77, Nrupatunga Road, Bangalore - 560001");
	l.add("No. 29, Ground Floor, Infantry Road, Bangalore - 560001 (Near Income Tax Office)");
	l.add("Ground Floor, Ahuja Chambers No.1, Kumarapark Road, Race Course Road, Bangalore - 560001 (Opposite Race Course)");
	l.add("Ground Floor, Ahuja Chambers No.1, Kumarapark Road, Race Course Road, Bangalore - 560001 (Opposite Race Course)");
	 m.addAttribute("name", "Hdfc Bank Pvt Lmtd.");
	 m.addAttribute("branch", l);
	return "branches";
	}
	@RequestMapping(value="/services",method = RequestMethod.GET)
	public String getServices(ModelMap m) {
		List<String> l=new ArrayList<>();
		l.add("Auto loans.");
		l.add("Credit and debit cards.");
		l.add("Personal loans.");
		l.add("Home loans.");
		l.add("Gold loans.");
		l.add("Mortgages.");		
		l.add("Commercial vehicles finance");
		l.add("Retail business banking.");
		l.add("Savings account");
		l.add("Current account");
		m.addAttribute("services", l);
		m.addAttribute("name","Hdfc Bank Pvt Lmtd.");
		
		return "Services";
	}
}
