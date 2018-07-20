package demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 15:16 2018/7/10 .
 */
public class SelectSort {

    public static void main(String[] args) {
        String time = "19:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String targetTime = sdf.format(now)+" " + time +":00";
        try {
            Date targetDate = sdf1.parse(targetTime);
            System.out.println("now:" + now + "time:"+ now.getTime());
            System.out.println("target:" + targetDate + "targetTime:" + targetDate.getTime());
            System.out.println(now.getTime() - targetDate.getTime());
            System.out.println(now.getHours());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String exclusionTime = "00:00,00:30,01:00";
        String[] exclusionTimeArray = exclusionTime.split("\\,");
        for(String str : exclusionTimeArray){
            System.out.println(str);
        }

    }


}
