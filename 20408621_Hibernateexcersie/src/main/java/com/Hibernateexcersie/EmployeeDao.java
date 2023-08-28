package com.Hibernateexcersie;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

import java.util.*;

/**
 * Hello world!
 *
 */
public class EmployeeDao
{
	Configuration cfg = new Configuration();
    SessionFactory factory=cfg.configure("hibernate.cfg.xml").buildSessionFactory();

	public void AddEmployee(EmployeeDetails emp) throws ParseException {
		Session ses=factory.openSession();
		Transaction tx=ses.beginTransaction();
		ValidatorFactory validfactory=Validation.buildDefaultValidatorFactory();
        Validator validator=validfactory.getValidator();
        Set<ConstraintViolation<EmployeeDetails>> se=validator.validate(emp);
        if(se.size()>0) {
        	for(ConstraintViolation<EmployeeDetails> e:se)
        	System.out.println(e.getMessage());
        	options();
        }else {	
        	if(emp.getEmpJod().getYear()-emp.getEmpDob().getYear()<18) {
        		System.out.println("\n\n*****The age difference between joining date and date of birth shoould be greaterthan 18.");
        		options();
        	}else {
        	ses.persist(emp);
        	tx.commit();
        	System.out.println("\n\n\n Employee Added Succesfully...........");
        	ses.close();
        	options();
        	}
        }
	}
	public void DisplayEmployeeDetails() throws ParseException {
		Session ses=factory.openSession();
		Query query=ses.createQuery("from EmployeeDetails");
		List<EmployeeDetails> ls=query.getResultList();
		System.out.println("Employee details");
		System.out.println("_________************____________");
		for(EmployeeDetails emp:ls) {
			System.out.println("EmpCode := "+emp.getId()+
					"\nEmpName := "+emp.getEmpName()+
					"\nEmpAge := "+emp.getEmpAge()+
					"\nEmpDesignation := "+emp.getEmpDesignation()+
					"\nEmpDob := "+emp.getEmpDob().toString()+
					"\nEmpJod := "+emp.getEmpJod().toString()+
					"\nEmpBasicSalary := "+emp.getEmpBasicSalary());
			System.out.println("======================================================================");
		}
		ses.close();
		options();
		
	}
	public void DeleteEmployee(long id) throws ParseException {
		Session ses=factory.openSession();
		String hql="Delete from EmployeeDetails e where e.id =:id";
		Transaction tx=ses.beginTransaction();
		EmployeeDetails emp=ses.get(EmployeeDetails.class, id);
		EmployeeLogTab tab=new EmployeeLogTab();
		tab.setId(emp.getId());
		tab.setEmpdes(emp.getEmpDesignation().toString());
		tab.setName(emp.getEmpName());
		tab.setDate(new Date());
		float basic=emp.getEmpBasicSalary();
		float da=(float) (0.2*basic);
		float hra=(float) (0.1*basic);
		long salary=(long)(basic+da+hra);
		tab.setSalary(salary);
		Query q=ses.createQuery(hql);
		q.setParameter("id", id);
		int excup=q.executeUpdate();
		if(excup > 0) {
			ses.persist(tab);
			System.out.println("Deleted Successfully.........");
			tx.commit();
			ses.close();
			options();
			
		}
		else {
			System.out.println("Id not Found ........");
			ses.close();
			options();
		}
		
		
	}
	public void updateEmployee(long id)throws ParseException {
		Scanner sc = new Scanner(System.in);
		Session se=factory.openSession();
		Transaction tx=se.beginTransaction();
		EmployeeDetails emp=se.get(EmployeeDetails.class, id);
		System.out.println(emp.toString());
		System.out.println("----------------------");
		System.out.println("choose option to update following filed :\n");
		System.out.println("\n1.Empdesignation\n2.Basic Salary\n3.EmpJod\n4.EmpDob\n5.Empname\n6.EmpAge\n7.Exit");
		int opt=sc.nextInt();
		switch(opt) {
		case 1:
			System.out.println("Enter Designation (SE, SSE, SS, SSS) :");
			emp.setEmpDesignation(EmpDesignation.valueOf(sc.next()));
			UpdateLogTable up=new UpdateLogTable(0,emp.getId(),new Date(),"Employee Designation changed");
			se.persist(emp);
			se.persist(up);
			tx.commit();
			updateEmployee(id);
			break;
		case 2:
			System.out.println("Enter Salary to update : ");
			emp.setEmpBasicSalary(sc.nextLong());
			se.persist(emp);
			UpdateLogTable upb=new UpdateLogTable(0,emp.getId(),new Date(),"Employee Basic salary changed");
			se.persist(upb);
			tx.commit();
			updateEmployee(id);
			break;
		case 3:
			System.out.println("Enter JOD to update (YYYY-MM-DD) : ");
			emp.setEmpJod(new SimpleDateFormat("yyyy-MM-dd").parse(sc.next()));
			se.persist(emp);
			UpdateLogTable upj=new UpdateLogTable(0,emp.getId(),new Date(),"Employee Joining date  changed");
			se.persist(upj);
			tx.commit();
			updateEmployee(id);
			break;
		case 4:
			System.out.println("Enter DOB to update (YYYY-MM-DD) : ");
			emp.setEmpDob(new SimpleDateFormat("yyyy-MM-dd").parse(sc.next()));
			se.persist(emp);
			System.out.println("\n\nUpdated Successfully..................");
			UpdateLogTable upd=new UpdateLogTable(0,emp.getId(),new Date(),"Employee Date of birth changed");
			se.persist(upd);
			tx.commit();
			updateEmployee(id);
			break;
		case 5:
			System.out.println("Enter Name to Update  : ");
			sc.nextLine();
			emp.setEmpName(sc.nextLine());
			se.persist(emp);
			UpdateLogTable upn=new UpdateLogTable(0,emp.getId(),new Date(),"Employee Name changed");
			se.persist(upn);
			tx.commit();
			updateEmployee(id);
			break;
		case 6:
			System.out.println("Enter Age to Update : ");
			emp.setEmpAge(sc.nextInt());
			se.persist(emp);
			UpdateLogTable upa=new UpdateLogTable(0,emp.getId(),new Date(),"Employee Age changed");
			se.persist(upa);
			tx.commit();
			updateEmployee(id);
			break;
		case 7:
			options();
			break;
		default:
			System.out.println("OOps Invalid option.....");
			updateEmployee(id);
			break;
		}
		sc.close();
		options();
	}
	public void paySlip(long id) throws ParseException {
		
		Session s=factory.openSession();
		EmployeeDetails emp=s.get(EmployeeDetails.class, id);
		System.out.println("\t\t\t\t\n\n\n\n================\nA GOBAL SOFTWARE CompanyPaySlip....\n\n\n");
		System.out.println("\t\t\t\t\t\t\t\t\tDate: "+new Date());
		float basic=emp.getEmpBasicSalary();
		float da=(float) (0.2*basic);
		float hra=(float) (0.1*basic);
		long salary=(long)(basic+da+hra);
		System.out.println("Employee Code: "+emp.getId()+"\nEmployee Name: "+emp.getEmpName()+
				"\nEmployee Designation : "+emp.getEmpDesignation().toString()+
				"\nEmployee Dob : "+emp.getEmpDob()+
				"\nEmployee Jod : "+emp.getEmpJod()+"\n\n\n"+"Basic : "+emp.getEmpBasicSalary()+"\nHRA : "+hra+"\nDA : "+da+
				"\nEmployee salary : "+salary+"\n\n"+"...........");
		
		
		options();
	}
		
	public void options() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add Employee\n"
				+ "2.Display Employee\n"
				+ "3.Delete Employee\n"
				+ "4.Update Employee\n"
				+ "5.Pay Slip\n"
				+ "6.Exit");
		System.out.println("Choose option :");
		int n =sc.nextInt();
		try {
		switch(n) {
		
		case 1:
			
			System.out.println("Enter Employee Name, Designation, Date of birth(YYYY-MM-DD) ,Joinig Date(YYYY-MM-DD), Age ,Basic Salary");
			System.out.println("**Note : For designation choose SE, SSE, SS, SSS ");
			sc.nextLine();
			EmployeeDetails emp=new EmployeeDetails(0, sc.nextLine(), EmpDesignation.valueOf(sc.next()), new SimpleDateFormat("yyyy-MM-dd").parse(sc.next()), new SimpleDateFormat("yyyy-MM-dd").parse(sc.next()), sc.nextInt(), sc.nextLong());
			AddEmployee(emp);
			break;
		case 2:
			DisplayEmployeeDetails();
			break;
		case 3:
			System.out.println("Enter Employee Code to Delete:");
			long code = sc.nextLong();
			DeleteEmployee(code);
			break;
		case 4:
			System.out.println("Enter Employee Code to Update:");
			int empcode=sc.nextInt();
			updateEmployee(empcode);
			break;
		case 5:
			System.out.println("Enter employee Code to generate pay slip:");
			long l=sc.nextLong();
			paySlip(l);
			break;
		case 6:
			System.out.println("\n\n-----------------"+"Exited Succesfully...");
			break;
		default: 
			System.out.println("Invalid option.........");
			options();
			break;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
		
	}
}
