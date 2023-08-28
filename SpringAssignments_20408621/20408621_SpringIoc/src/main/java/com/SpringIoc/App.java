package com.SpringIoc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ap=new AnnotationConfigApplicationContext(Config.class);
        Student st1=(Student) ap.getBean("std1");
        st1.show();
        Student st2=(Student) ap.getBean("std2");
        st2.show();
    }
}
