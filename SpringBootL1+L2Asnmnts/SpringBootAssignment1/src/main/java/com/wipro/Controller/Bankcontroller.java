package com.wipro.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bankcontroller {
	
	@GetMapping("/name")
	public String GetName() {
		return "HDFC pvt Lmtd.";
	}
	@GetMapping("/address")
	public String GetAddress() {
		return "Ramalingapuram, muthukur road, Nellore, Andhra Pradesh - 524309";
	}
}
