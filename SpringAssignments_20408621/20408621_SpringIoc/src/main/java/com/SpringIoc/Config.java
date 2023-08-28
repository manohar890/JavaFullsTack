package com.SpringIoc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean(name="std1")
	public Student st1() {
		Test t = new Test("TOO1","Java","90");
		List<Test> t1 = new ArrayList<Test>();
		t1.add(t);
		return new Student("Std1", "Manohar", t1);
		
	}

	@Bean(name="std2")
	public Student st2() {
		Test t = new Test("TOO1","Java","90");
		Test t1 = new Test("TOO2","Python","89");
		List<Test> l1 = new ArrayList<Test>();
		l1.add(t1);l1.add(t);
		return new Student("Std2", "Raju", l1);
		
	}
}
