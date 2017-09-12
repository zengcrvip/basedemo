package demo.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataHelper {

    public static String getStrEx(Map<String, Object> data, String key) {
        if (!data.containsKey(key)) {
            throw new IllegalArgumentException("不存在该字段【" + key + "】");
        }
        return data.get(key).toString();
    }

    public static int getIntEx(Map<String, Object> data, String key) {
        if (!data.containsKey(key)) {
            throw new IllegalArgumentException("不存在该字段【" + key + "】");
        }
        return Integer.parseInt(data.get(key).toString());
    }

    public static int getInt(Map<String, Object> data, String key) {
        return getInt(data, key, 0);
    }

    public static int getInt(Map<String, Object> data, String key, int defaultValue) {
        if (!data.containsKey(key) || data.get(key) == null || "".equals(data.get(key).toString())) {
            return defaultValue;
        }
        return Integer.parseInt(data.get(key).toString());
    }

    public static boolean getBoolean(Map<String, Object> data, String key) {
        return getBoolean(data, key, false);
    }

    public static boolean getBoolean(Map<String, Object> data, String key, boolean defaultValue) {
        if (!data.containsKey(key) || data.get(key) == null || "".equals(data.get(key).toString())) {
            return defaultValue;
        }
        return Boolean.parseBoolean(data.get(key).toString());
    }

    public static long getLong(Map<String, Object> data, String key) {
        return getLong(data, key, 0L);
    }

    public static long getLong(Map<String, Object> data, String key, long defaultValue) {
        if (!data.containsKey(key) || data.get(key) == null || "".equals(data.get(key).toString())) {
            return defaultValue;
        }
        return Long.parseLong(data.get(key).toString());
    }

    public static double getDouble(Map<String, Object> data, String key) {
        return getDouble(data, key, 0d);
    }

    public static double getDouble(Map<String, Object> data, String key, double defaultValue) {
        if (!data.containsKey(key) || data.get(key) == null || "".equals(data.get(key).toString())) {
            return defaultValue;
        }
        return Double.parseDouble(data.get(key).toString());
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss类型日期数据，转换前字符串必须符合yyyy-MM-dd HH:mm:ss格式。
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static Timestamp getDate(Map<String, Object> data, String key) {

        String initDate = "1960-1-1 00:00:00";
        if (data.containsKey(key)) {
            initDate = data.get(key).toString();
        }
        return toTimestamp(initDate);
    }

    public static Map<String, Object> toMap(String[] arrs) {
        Map<String, Object> data = new HashMap<String, Object>();
        for (int i = 0; i < arrs.length; i++) {
            data.put(arrs[i], arrs[i]);
        }

        return data;
    }

    /**
     * 如果目标IMap里面没有该键值或为null或为"",则返回默认值
     * 
     * @param srcData
     * @param key
     * @param defaultValue
     * @return
     * @throws Exception
     */
    public static String getStr(Map<String, Object> srcData, String key, String defaultValue) {

        if (!srcData.containsKey(key) || srcData.get(key) == null || srcData.get(key).toString().trim().equals("")) {
            return defaultValue;
        } else {
            return srcData.get(key).toString();
        }
    }

    /**
     * 如果目标IMap里面没有该键值或为null或为"",则抛出异常
     * 
     * @param srcData
     * @param key
     * @return
     * @throws Exception
     */
    public static String getStr(Map<String, Object> srcData, String key) {

        return getStr(srcData, key, "");
    }

    // int 转化成 String
    public static String toStr(int value) {
        return Integer.toString(value);
    }

    // double 转化成 String 并格式化成0.00
    public static String toStr(double value) {
        return toFormat(Double.toString(value));
    }

    // long 转化成 String
    public static String toStr(long value) {
        return Long.toString(value);
    }

    // String 转化成 double 并进行格式化
    public static double toDouble(Object obj) {
        String value;
        if (obj == null) {
            value = "0.00";
        } else {
            value = obj.toString().trim();
        }
        if (value == null || value.length() == 0) {
            return 0.00;
        } else {
            return (Double.valueOf(value)).doubleValue();
        }
    }

    // 数字的String 格式化0.00后输出
    public static String toFormat(Object obj) {
        double value = toDouble(obj);
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);
    }

    public static String div100(double value) {
        return toStr(value / 100);
    }

    public static String div100(String value) {
        return value == null ? "0.00" : toFormat(div100(toDouble(value)));
    }

    public static List<?> sortByString(List<?> ls, String sortKey) {
        Object[] datas = (Object[]) ls.toArray();
        DataComparator c = new DataComparator(sortKey, 2, 0);
        Arrays.sort(datas, c);

        return Arrays.asList(datas);
    }

    public static List<?> sortByInt(List<?> ls, String sortKey) {
        Object[] datas = (Object[]) ls.toArray();
        DataComparator c = new DataComparator(sortKey, 3, 0);
        Arrays.sort(datas, c);

        return Arrays.asList(datas);
    }

    public static Date toDate(String strDate) {
        try {

            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date date = bartDateFormat.parse(strDate);
            return new Date(date.getTime());
        } catch (Exception e) {
            throw new IllegalArgumentException("将【" + strDate + "】转换为日期类型失败！");
        }
    }

    public static Timestamp toTimestamp(String strDate) {

        if ("".equals(strDate) || strDate == null) {
            strDate = "1960-1-1 00:00:00";
        }

        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {

            java.util.Date date = bartDateFormat.parse(strDate);
            Date sqlDate = new Date(date.getTime());
            return new Timestamp(sqlDate.getTime());
        } catch (Exception pe) {
            try {

                bartDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

                java.util.Date date = bartDateFormat.parse(strDate);
                Date sqlDate = new Date(date.getTime());
                return new Timestamp(sqlDate.getTime());
            } catch (Exception pe1) {
                try {

                    bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    java.util.Date date = bartDateFormat.parse(strDate);
                    Date sqlDate = new Date(date.getTime());
                    return new Timestamp(sqlDate.getTime());
                } catch (Exception pe2) {
                    throw new IllegalArgumentException("将【" + strDate + "】转换为日期类型失败！");
                }
            }
        }
    }

    public static String toDateStr(Timestamp date, String format) {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
        java.util.Date d = new java.util.Date(date.getTime());
        return bartDateFormat.format(d);
    }
    
    /**
     * add by 15020105
     * 功能描述：MAP转换成需要的对象，当MAP中没有此对象的属性时不对此属性进行赋值操作
     * 输入参数：<按照参数定义顺序> 
     * @param 参数说明
     * 返回值:  类型 <说明> 
     * @return 返回值
     * @throw 异常描述
     */
    public static <T> T mapToBean(Map  map,Class<T> clazz){
        try {
            T t = clazz.newInstance();
            BeanInfo beanInfo=Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (int i = 0; i< propertyDescriptors.length; i++) { 
                PropertyDescriptor descriptor = propertyDescriptors[i]; 
                String propertyName = descriptor.getName();
                if("class".equals(propertyName)) {
                	continue;
                }
                if (map.containsKey(propertyName)) { 
                    Object value = map.get(propertyName); 
                    Object[] args = new Object[1]; 
                    args[0] = value; 
                    descriptor.getWriteMethod().invoke(t, args); 
                } 
            } 
            return t;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * add by 15020105
     * 功能描述：MAP转换成需要的对象，当MAP中没有此对象的属性时不对此属性进行赋值操作
     * 输入参数：<按照参数定义顺序> 
     * @param 参数说明
     * 返回值:  类型 <说明> 
     * @return 返回值
     * @throw 异常描述
     */
    public static Map<String,Object> beanToMap(Object bean){
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            BeanInfo beanInfo=Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (int i = 0; i< propertyDescriptors.length; i++) { 
                PropertyDescriptor descriptor = propertyDescriptors[i]; 
                String propertyName = descriptor.getName();
                if("class".equals(propertyName)) {
                	continue;
                }
                Method readMethod = descriptor.getReadMethod();
                Object obj = readMethod.invoke(bean, new Object[0]);
                map.put(propertyName, obj);
            } 
            return map;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * add by 15020105
     * 功能描述：把有上下级结构的数据转换成带有children的树型结构，
     * 例如：[{id:'1',name:'tree1',pid:''},{id:'2',name:'tree1',pid:'1'}]
     * 转换成：
     * [{id:'1',name:'tree1',pid:'',children:[{id:'2',name:'tree1',pid:'1'}}]
     * 
     * 输入参数：<按照参数定义顺序> 
     * @param 参数说明
     * 返回值:  类型 <说明> 
     * @return 返回值
     * @throw 异常描述
     */
    public static List<Map<String,Object>> toTreeChildrenList(List<Map<String,Object>> list,
            String idField,String parentField,String childrenField) {
        
    	List<Map<String,Object>> retlist = new ArrayList<Map<String,Object>>();
	   	Map<String,Map<String,Object>> tempMap = new HashMap<String,Map<String,Object>>();
	   	 //先把数据放入中间MAP中
		for (Map<String, Object> map : list) {
			tempMap.put(String.valueOf(map.get(idField)), map);
		}
		for (Map<String, Object> map : list) {
			Map<String, Object> tp = tempMap.get(String.valueOf(map.get(parentField)));
			if (tp != null && !String.valueOf(map.get(idField)).equals(map.get(parentField))) {
				Object childObj = tempMap.get(String.valueOf(map.get(parentField))).get(childrenField);
				if (childObj == null) {
					List<Map<String, Object>> chList = new ArrayList<Map<String, Object>>();
					chList.add(map);
					tempMap.get(String.valueOf(map.get(parentField))).put(childrenField, chList);
				} else {
					((List<Map<String, Object>>) tempMap.get(String.valueOf(map.get(parentField))).get(childrenField))
							.add(map);
				}
			} else {
				retlist.add(map);
			}
		}
	   	tempMap.clear();
    	tempMap = null;
        /*Boolean []bo = new Boolean[list.size()];
        for(Map<String,Object> map:list) {
            for(int k=0;k<list.size();k++) {
                Map<String,Object> submap = list.get(k);
                if(String.valueOf(map.get(idField)).equals(String.valueOf(submap.get(parentField)))) {
                   List chlist =  (List)map.get(childrenField);
                   if(chlist == null) {
                       chlist = new ArrayList<Map<String,Object>>();
                   }
                   chlist.add(submap);
                   map.put(childrenField, chlist);
                   bo[k] = true;
                }
            }
        }
        List<Map<String,Object>> retlist = new ArrayList<Map<String,Object>>();
        for(int i=0;i<bo.length;i++) {
            if(bo[i] == null) {
                retlist.add(list.get(i));
            }
        }*/
        return retlist;
    }
    
    /**
     * 获取字段所有值
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param data
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<?> getFieldValues(List<Map<String, Object>> data, String key){
        List<Object> list = new ArrayList<Object>();
        for(Map<String, Object> row : data){
            list.add(row.get(key));
        }
        return list;
    }
    
    public static void main(String[] args){
    	//1、查看map对象中是否包含key
    	Map<String,Object> map = new HashMap<String,Object>();
    	System.out.println("DataHelper.getStr="+DataHelper.getStrEx(map, "key1"));
    }
}
