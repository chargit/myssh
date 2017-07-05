package web.action;


import domain.Department;
import domain.Employee;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import service.imp.EmployeeService;
import service.interfaces.DepartmentServiceInter;
import service.interfaces.EmployeeServiceInter;
import web.forms.EmployeeForm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ww on 2017/6/27.
 */
public class EmployeeAction extends DispatchAction {




    private DepartmentServiceInter departmentService;

    public DepartmentServiceInter getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentServiceInter departmentService) {
        this.departmentService = departmentService;
    }

    public EmployeeServiceInter getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeServiceInter employeeService) {
        this.employeeService = employeeService;
    }

    private EmployeeServiceInter employeeService;



    public ActionForward addEmpUi(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {


        return mapping.findForward("goAddEmpUi");
    }

    public ActionForward addEmp(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {

        EmployeeForm employeeForm = (EmployeeForm) form;
        Employee employee = new Employee();
        employee.setEmail(employeeForm.getEmail());
        employee.setGrade(Integer.parseInt(employeeForm.getGrade()));
        employee.setHiredate(new java.util.Date());
        employee.setName(employeeForm.getName());
        employee.setPwd(employeeForm.getPwd());
        employee.setSalary(Float.parseFloat(employeeForm.getSalary()));

        employee.setDepartment((Department)departmentService.findById(Department.class, Integer.parseInt(employeeForm.getDepartmentId())));

        employeeService.add(employee);
        return mapping.findForward("operok");


    }


    public ActionForward goListEmpUi(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        String s_pageNow=request.getParameter("pageNow");
        int pageNow=1;
        if(s_pageNow!=null){
            pageNow=Integer.parseInt(s_pageNow);
        }
        request.setAttribute("emplist", employeeService.showEmpList(3,pageNow));

        int pageCount = employeeService.getPageCount(3);
        request.setAttribute("pageCount", pageCount);

        return mapping.findForward("goListEmp");
    }


    public ActionForward delEmp(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        String id=request.getParameter("id");

        try{

            employeeService.delById(Employee.class, Integer.parseInt(id));

        }catch(Exception e){
            return mapping.findForward("opererr");
        }

        return mapping.findForward("operok");
    }

    public ActionForward goUpdEmpUi(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {

        String id=request.getParameter("id");

        Employee e = (Employee) employeeService.findById(Employee.class, Integer.parseInt(id));
        request.setAttribute("emp", e);



        return mapping.findForward("goUpdEmpUi");
    }

    public ActionForward updEmp(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        EmployeeForm ef = (EmployeeForm)form;

        Employee employee = new Employee();
        employee.setId(Integer.parseInt(ef.getId()));
        employee.setEmail(ef.getEmail());
        employee.setName(ef.getName());
        employee.setPwd(ef.getPwd());
        employee.setSalary(Float.parseFloat(ef.getSalary()));
        employee.setGrade(Integer.parseInt(ef.getGrade()));
        employee.setDepartment((Department) departmentService.findById(Department.class, Integer.parseInt(ef.getDepartmentId())));

        try{
            employeeService.update(employee);

        }catch(Exception e){
            return mapping.findForward("opererr");
        }

        return mapping.findForward("operok");

    }

}
