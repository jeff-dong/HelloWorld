package jxdong.web.global;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppLifeCycleListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("=== onStartup ("+SysConfig.getString("Version")+") ===");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("=== onShutdown ("+SysConfig.getString("Version")+") ===");
    }
}
