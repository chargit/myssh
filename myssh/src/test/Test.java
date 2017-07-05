package test;

import domain.Department;
import domain.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hibernate.Session;
import service.interfaces.DepartmentServiceInter;
import service.interfaces.EmployeeServiceInter;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by ww on 2017/6/12.
 */
public class Test {

    public static void main(String[] args)  {

        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeServiceInter employeeServiceInter = (EmployeeServiceInter)ac.getBean("employeeService");
        DepartmentServiceInter dsf = (DepartmentServiceInter)ac.getBean("departmentService");


        Employee employee=new Employee("admin","aabbc@sohu.com","123",1, new java.util.Date(), 1000.56f);
        Employee employee2=new Employee("admin2","aabbc@sohu.com","123",1, new java.util.Date(), 1000.56f);
        Employee employee3=new Employee("admin4","aabbc@sohu.com","123",1, new java.util.Date(), 1000.56f);

//        employeeServiceInter.addEmployee(employee);
//        employeeServiceInter.addEmployee(employee2);
//        employeeServiceInter.addEmployee(employee3);


        Department dpm = new Department("IT");
//
//        Set<Employee> sets= new HashSet<Employee>();
//        sets.add(employee);
//        sets.add(employee2);
//        sets.add(employee3);
//
//        dpm.setEmps(sets);
//
//        dsf.addDepartment(dpm);


    }
}
