package listener;

import util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DBConnectionListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public DBConnectionListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        DBUtil util = new DBUtil();
        Map map = new HashMap();

        //处理高并发动态开辟（保留）

        //定义连接数目
        final int connection_size = 30;

        System.out.println("开始创建连接，默认开辟连接数：" + connection_size);
        for (int i = 1; i <= connection_size; i++) {
            Connection con = util.getCon();
            System.out.println("创建" + i + "号连接对象： " + con);
            //true：初始状态下通道空闲
            map.put(con, true);
        }
        //在整个服务器运行期间使用
        ServletContext application = sce.getServletContext();
        application.setAttribute("con", map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        ServletContext application = sce.getServletContext();
        Map map = (Map) application.getAttribute("con");
        //迭代器排序无序数据
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Connection con = (Connection) it.next();
            if (con != null)
                System.out.println("连接" + con + "已销毁");
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
