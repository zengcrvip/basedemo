package demo.test;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 10:57 2018/2/24 .
 */
public class Single {
    private static Single single = null;

    private Single(){}

    public static Single getSingle(){
        if(single == null){
            synchronized (Single.class){
                if(single == null){
                    single = new Single();
                }
            }
        }
        return single;
    }
}
