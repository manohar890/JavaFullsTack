package com.springL2.assignment3.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springL2.assignment3.mode.Marks;



@Controller
@RequestMapping(value = "/")
public class MarksController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewmarksForm(Map<String, Object> model) {
		Marks marks=new Marks();	
		model.put("marks",marks);
		
		//int totalMarks=marks.getEnglishMarks()+marks.getMathsMarks()+marks.getScienceMarks();
		return "marksForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String viewmarksForm(Marks marks,Model model) {
		
		
		int total=marks.getEnglish()+marks.getMathematics()+marks.getScience();
		//System.out.println(totalMarks);
		model.addAttribute("totalMarks",total);
		return "result";
	}
	
	
}
