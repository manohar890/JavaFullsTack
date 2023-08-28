package com.microservice.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.microservice.Model.*;

@Controller
public class controller {
	
	List<Patients> lis1=new ArrayList<Patients>();
	List<Services> lis = new ArrayList<Services>();
	@GetMapping("/")
	public String Hello() {
		return "index";
	}
	@GetMapping("/FormPatient")
	public String PatientForm(Patients patients) {
		return "PatientForm";
	}
	 @PostMapping("/addPatient")
	    public String addPatient( Patients patients, Model model) {
		 Patients p = new Patients();
		 p.setId(patients.getId());
		 p.setFirstname(patients.getFirstname());
		 p.setLastname(patients.getLastname());
		 p.setServices(lis);
	        
	        lis1.add(p);
	        return "redirect:/";
	    }
	 @GetMapping("/FormService")
		public String FormService(Services services) {
			return "ServiceForm";
		}
		 @PostMapping("/addService")
		    public String addService( Services services, Model model) {  
		        lis.add(services);
		        return "redirect:/";
		    }
	@GetMapping("/allPatients")
	public String getAllProducts(Model model) {
		model.addAttribute("data", lis1);
		return "showPatients";
		
	}
	@GetMapping("/allServices")
	public String getAllServices(Model model) {
		model.addAttribute("data", lis);
		return "showServices";
		
	}
	@GetMapping("/countofpatient")
	public String countOfPatient(Model m) {
		m.addAttribute("count", "Number of Patients = "+lis1.size());
		return "/count";
	}
	@GetMapping("/countofservice")
	public String countOfservice(Model m) {
		m.addAttribute("count", "Number of Services available = "+lis.size());
		return "/count";
	}
	@PostMapping("/getPatient")
	public String getPatient(@RequestParam("id") int id, Model m) {
		List<Patients> li=lis1.stream().filter(x->x.getId()==id).toList();
		m.addAttribute("data", li);
		return "showPatients";
	}
}
