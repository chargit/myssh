package service.imp;

import basic.BasicService;
import domain.Department;
import domain.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.EmployeeServiceInter;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ww on 2017/6/13.
 */
public class EmployeeService extends BasicService implements EmployeeServiceInter {


    public List showEmpList(int pageSize, int pageNow){

        String hql="from Employee order by id";
        return this.executeQueryByPage(hql, null, pageNow, pageSize);

    }


    public int getPageCount(int pageSize){

        String hql="select count(*) from Employee ";

        return this.queryPageCount(hql, null, pageSize);


    }

    public Employee checkEmployee(Employee e) {

        String hql="from Employee where id=? and pwd=? ";

        Object []parameters = {e.getId(), e.getPwd()};

        List list = this.executeQuery(hql, parameters);

        if(list.size()==0){

            return null;
        }else{

            return (Employee)list.get(0);
        }

    }
}
