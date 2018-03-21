package demo.test;

import java.util.*;

/**
 * Created by changrong.zeng on 2018/1/9.
 */
public class ListconvertMap {
    public static void main(String[] args) {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("HEADID","head1");
        map1.put("ORDERSEQID","orderSeq1");
        map1.put("MEMBERCODE","code1");
        map1.put("LISTID", "list1");
        list.add(map1);

        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("HEADID","head2");
        map2.put("ORDERSEQID","orderSeq2");
        map2.put("MEMBERCODE","code2");
        map2.put("LISTID", "list2");
        list.add(map2);

        Map<String,String> map3 = new HashMap<String, String>();
        map3.put("HEADID","head3");
        map3.put("ORDERSEQID","orderSeq3");
        map3.put("MEMBERCODE","code3");
        map3.put("LISTID", "list3");
        list.add(map3);

        ListconvertMap object = new ListconvertMap();
        Map result = object.listconvertMap(list);
        System.out.println("aaaa");

    }


    private Map listconvertMap(List<Map<String,String>> list) {
        Map<String, List<Object>> result = new HashMap<String, List<Object>>();

        boolean flag = false;
        for (Map record : list) {
            Set<String> set = record.keySet();
            for (String key : set) {
                if (flag) {
                    List<Object> row = result.get(key);
                    row.add(record.get(key));
                } else {
                    List<Object> row = new ArrayList<Object>();
                    result.put(key, row);
                    row.add(record.get(key));
                }
            }
            flag = true;
        }

        return result;
    }
}
