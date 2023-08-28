package com.SpringIoc2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        List<Player> players =new ArrayList<Player>();
        Player p1=(Player) ap.getBean("p1");
        Player p2=(Player) ap.getBean("p2");
        Player p3=(Player) ap.getBean("p3");
        Player p4=(Player) ap.getBean("p4");
        Player p5=(Player) ap.getBean("p5");
        players.add(p1); players.add(p2); players.add(p3); players.add(p4); players.add(p5);
        players.stream().forEach(x->{System.out.println("Player : "+x.getPlayerId()+" "+x.getPlayerName());
        System.out.println("Country : "+x.getCountry().getCountryId()+" "+x.getCountry().getCountryName());
        System.out.println("________________________________");
        });
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Country Name");
        String s=sc.next();
        players.stream().filter(x->x.getCountry().getCountryName().equals(s)).forEach(x->{System.out.println("Player : "+x.getPlayerId()+" "+x.getPlayerName());
        });
    }
}
