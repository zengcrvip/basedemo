package demo.proxydemo.dynamic;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 20:20 2018/8/1 .
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 实例化目标对象
        UserService userService = new UserServiceImpl();
        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        // 根据目标对象生成代理对象
        UserService proxy  = (UserService)invocationHandler.getProxy();
        proxy.add();

    }
}
