package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理登录筛选逻辑
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session;

        //统一页面编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //动态获取Web项目名
        final String webapp_name = req.getServletContext().getContextPath() + "/";

        //case 1：请求登录相关文件
        String uri = req.getRequestURI();
        if (uri.contains("login") || uri.contains("regist") || webapp_name.equals(uri)) {
            chain.doFilter(request, response);
            return;
        }

        //case 2：请求其他文件
        session = req.getSession(false);
        if (session.getAttribute("loginUser") != null) {
            chain.doFilter(request, response);
            return;
        }

        PrintWriter out = response.getWriter();
        out.write("<script>alert('未登录，请先登录！'); window.location='login.jsp'</script>");

        out.flush();
        out.close();
    }
}
