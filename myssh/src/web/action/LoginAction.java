package web.action;

import domain.Employee;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.interfaces.EmployeeServiceInter;
import web.forms.EmployeeForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ww on 2017/6/15.
 */
public class LoginAction extends DispatchAction{

    public void setEmployeeService(EmployeeServiceInter employeeService) {
        System.out.print("setEmployeeServiceInter");
        this.employeeService = employeeService;
    }
    @Resource
    EmployeeServiceInter employeeService;

    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        EmployeeForm employeeForm = (EmployeeForm)form;
        System.out.print("ACTION!!!"+employeeForm.getId()+"---"+employeeForm.getPwd());

//        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());

//        EmployeeServiceInter employeeServiceInter = (EmployeeServiceInter)ctx.getBean("employeeService");

        Employee e = new Employee();
        e.setId(Integer.parseInt(employeeForm.getId()));
        e.setPwd(employeeForm.getPwd());
        e=employeeService.checkEmployee(e);



        if(e!=null){

            request.getSession().setAttribute("loginuser",e);
            return mapping.findForward("ok");
        }else{
            return mapping.findForward("err");
        }
    }

    public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        return super.execute(mapping, form, request, response);
    }

    public ActionForward goMainFrame(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {


        if(request.getSession().getAttribute("loginuser")!=null){
            return mapping.findForward("ok");

        }else{
            return mapping.findForward("err");

        }
    }
}
