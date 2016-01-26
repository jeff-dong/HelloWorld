package jxdong.web.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @author tangb
 * 该类和TomcatOnOffMonitor为两种不同应用开启和关闭时执行任务的方法。本应用使用Spring 方法。 
 */
@Component
public class SpringLifeCycleListener implements ApplicationListener {
	private static final Logger logger = LoggerFactory.getLogger(SpringLifeCycleListener.class);

	@Override
	public void onApplicationEvent(ApplicationEvent event) {

		if(event instanceof ContextStartedEvent){
			logger.info("The spring starts... , Version: {}", SysConfig.getString("Version"));

		}else if(event instanceof ContextRefreshedEvent){
			if(((ContextRefreshedEvent)event).getApplicationContext().getParent() == null) {
				logger.info("The spring starts successfully. Version: {}", SysConfig.getString("Version"));
			}

		}else if(event instanceof ContextClosedEvent){
			logger.info("The spring is closing... , Version: {}", SysConfig.getString("Version"));
		}
	}

	
}
