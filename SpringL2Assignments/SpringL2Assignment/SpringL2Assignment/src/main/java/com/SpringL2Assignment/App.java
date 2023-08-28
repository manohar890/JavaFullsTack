package com.SpringL2Assignment;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
	StudentDao sdao = ctx.getBean(StudentDao.class);
    			//Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
    		Scanner sc=new Scanner(System.in);
//    		sdao.add(new StudentData(0,"Lakshmi","Delhi"));
    		sdao.getAllDetails();
    		System.out.println("Enter Id to search :");
    		sdao.getDetails(sc.nextInt());
    }
}
