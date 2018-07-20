package demo.controller;

import demo.service.abstracttest.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 17:03 2018/7/19 .
 */
@Controller
public class AbstractClassDemo {

    @Autowired
    @Qualifier("serviceA")
    private ServiceA serviceA;

    @PostConstruct
    public void init(){
        String returnMsg = serviceA.service();
        System.out.println(returnMsg);
    }





}
