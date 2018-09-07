package demo.lock;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 17:58 2018/7/27 .
 */
public class RedisLockUtil {


    public static void main(String[] args) {
        int[] a = new int[]{10,12,23,14,22,14,25,45,34,2,3,8};
        for(int i=0;i<a.length;i++){
            int position = i;
            int temp = a[i];
            int j = i+1;
            for(;j<a.length;j++){
                if(a[j] < temp){
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }
        for(int i=0;i< a.length;i++){
            System.out.print(a[i] + ",");
        }

    }
}
