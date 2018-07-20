package demo.dao;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 17:09 2018/7/19 .
 */
@Component("baseDao")
public class BaseDAO {

    public String service(){
        return "success";
    }

    public String check(){
        return "check success";
    }
}
