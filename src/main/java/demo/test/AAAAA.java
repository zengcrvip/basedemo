package demo.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by changrong.zeng on 2017/12/6.
 */
public class AAAAA {

    public static void main(String[] args) {
        Userss s1 = new Userss(123,"张三");
        Userss s2 = new Userss(123,"张三重复");
        Userss s3 = new Userss(456,"李四");
        List<Userss> list = new ArrayList<Userss>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        print(list);

        StringBuffer sb = new StringBuffer();
        sb.append('[');
        Iterator<Userss> iterator = list.iterator();
        for(;;){
            Userss userss = iterator.next();
            sb.append(userss.getCode()).append(':').append(userss.getName());
            if(!iterator.hasNext()){
                sb.append(']');
                break;
            }else{
                sb.append(',').append(' ');
            }
        }
        System.out.println("list="+ sb.toString());

        System.out.println("==========改动后==================");

        List<Userss> array = new ArrayList<Userss>();
        for(Userss s:list){
            if(!array.contains(s)){
                array.add(s);
            }
        }
        print(array);




    }

    public static void print(List<Userss> list){
        for(Userss s: list){
            System.out.println(s.toString());
        }

    }
}
