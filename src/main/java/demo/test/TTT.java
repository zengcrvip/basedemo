package demo.test;

import java.math.BigDecimal;

/**
 * Created by changrong.zeng on 2017/12/12.
 */
public class TTT {
    public static void main(String[] args) {
        BigDecimal a = null;
        BigDecimal b = new BigDecimal(55555);
        String s = null;
        if(null != b){
             s = String.valueOf(a.subtract(b));
        }else{
             s = String.valueOf(a);
        }

        System.out.println(s);

    }
}
