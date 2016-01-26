package jxdong.web.job;

import jxdong.griotte.jobs.BaseQuartzJob;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/8/20 14:08
 */

@Service
public class JobTask2 extends BaseQuartzJob{
    private static final Logger logger = LoggerFactory.getLogger(JobTask2.class);


    @Override
    public void action(JobExecutionContext context) {
        logger.info("【JobTask2】 begin to execute...");


    }
}
