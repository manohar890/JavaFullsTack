package com.SpringIoc2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	Country c1=new Country("COO1","India");
	Country c2= new Country("C002","Australia");
	
	@Bean(name="p1")
	public Player bean1() {
		return new Player("POO1","Kohli",c1);
	}
	@Bean(name="p2")
	public Player bean2() {
		return new Player("POO2","Sehwag",c1);
	}
	@Bean(name="p3")
	public Player bean3() {
		return new Player("POO3","Yuvraj Singh",c1);
	}
	@Bean(name="p4")
	public Player bean4() {
		return new Player("POO4","Warner",c2);
	}
	@Bean(name="p5")
	public Player bean5() {
		return new Player("POO5","Australia",c2);
	}
}
