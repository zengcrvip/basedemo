package demo.javaconcurrentshizhan.chap1;

import java.math.BigInteger;

/**
 * Created by changrong.zeng on 2017/12/13.
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {

    public BigInteger compute(String arg) throws InterruptedException {
       // todo 长时间的计算逻辑
        return new BigInteger(arg);
    }
}
