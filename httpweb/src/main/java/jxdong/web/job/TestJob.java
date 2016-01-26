package jxdong.web.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/8/17 21:07
 */
@Component
public class TestJob {
    private static Logger logger = LoggerFactory.getLogger(TestJob.class);

    public void execute(){

        logger.info("------------------ Test job execute ("+new Date().getTime()+")------------------");
    }
}
