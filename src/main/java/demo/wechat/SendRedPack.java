package demo.wechat;

import java.util.concurrent.Executors;

/**
 *
 * Created by changrong.zeng on 2018/1/15.
 */
public class SendRedPack {
    public static void main(String[] args) {
        WeixinConfig.setKEY("12345678");
        WeixinConfig.setKEY_PATH("D://abc.txt");

        System.out.println(WeixinConfig.getKEY());
        System.out.println(WeixinConfig.getKEY_PATH());


        WeixinConfig.setKEY("ABCDEFG");
        WeixinConfig.setKEY_PATH("C://123.txt");

        System.out.println(WeixinConfig.getKEY());
        System.out.println(WeixinConfig.getKEY_PATH());

        Executors.newFixedThreadPool(1);

    }
}
