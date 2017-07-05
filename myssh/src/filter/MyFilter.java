package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by ww on 2017/6/22.
 */
public class MyFilter extends HttpServlet implements Filter {

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws ServletException, IOException{

        arg0.setCharacterEncoding("utf-8");
        arg2.doFilter(arg0, arg1);

    }

    public void init(FilterConfig arg0) throws  ServletException{

    }

}
