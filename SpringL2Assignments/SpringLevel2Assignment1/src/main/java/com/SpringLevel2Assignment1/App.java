package com.SpringLevel2Assignment1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ConfigurableApplicationContext app=new ClassPathXmlApplicationContext("beanConfig.xml");
         
         StudentDao dao=(StudentDao) app.getBean("Sdao");
          dao.addStudents();
          dao.getAllDetails();
          dao.getDetails(3);
          
    }
}
