package jxdong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MonitorController extends BasicController{

    @RequestMapping(value = "/monitor", method = RequestMethod.GET)
    public ModelAndView pageForward() {

        return modelAndView("monitor");
    }


}
