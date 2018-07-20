package demo.service.abstracttest;

import demo.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 17:11 2018/7/19 .
 */
public class BaseService {

    @Autowired
    @Qualifier("baseDao")
    protected BaseDAO baseDAO;

    public String check(){
        return baseDAO.check();
    }

}
