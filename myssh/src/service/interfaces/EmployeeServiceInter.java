package service.interfaces;

import basic.BasicServiceInter;
import domain.Employee;
import java.util.List;
/**
 * Created by ww on 2017/6/13.
 */
public interface EmployeeServiceInter extends BasicServiceInter {


    public Employee checkEmployee(Employee e);
    public int getPageCount(int pageSize);
    public List showEmpList(int pageSize, int pageNow);
}
