package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("echartsDemo")
public class EchartsDemo {
	
	@RequestMapping("/funnel")
    public String funnel(){        
        return "echartsDemo/funnel.ftl";
    }
	
	@RequestMapping("/funnel2")
    public String hello(){        
        return "echartsDemo/funel2.ftl";
    }
	
	@RequestMapping("/funnel3")
    public String funnel3(){        
        return "echartsDemo/funnel3.ftl";
    }

}
