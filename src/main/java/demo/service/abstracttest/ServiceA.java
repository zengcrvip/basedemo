package demo.service.abstracttest;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 17:14 2018/7/19 .
 */
@Service("serviceA")
public class ServiceA extends BaseService {

    public String service() {
        String check = super.check();
        return check +  baseDAO.service();
    }
}
