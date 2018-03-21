package demo.javaconcurrentshizhan.chap1;

import java.util.concurrent.Executors;

/**
 * Created by changrong.zeng on 2017/12/28.
 */
public class MemoizerTest {
    public static void main(String[] args) {
       Computable<String,String> computable = new Computable<String, String>() {
           public String compute(String arg) throws InterruptedException {
               return "s";
           }
       };
       Memoizer4<String,String> memoizer4 = new Memoizer4<String, String>(computable);

        Executors.newFixedThreadPool(200);


    }
}
