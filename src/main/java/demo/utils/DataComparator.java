package demo.utils;

import java.util.Comparator;
import java.util.Map;

/**
 * Data Comparator
 * 比较器
 */
public class DataComparator implements Comparator {
	private String key;  //比较字段key
 
	private int keyType; //比较类型 2：字符串  3：整型 4：double类型

	private int order;   //比较顺序  0:正序  其它：反序

	public DataComparator(String key, int keyType, int order) {
		this.key = key;
		this.keyType = keyType;
		this.order = order;
	}

	public int compare(Object o1, Object o2) {
		Map<String, Object> data1 = (Map<String, Object>) o1;
		Map<String, Object> data2 = (Map<String, Object>) o2;

		if (order == 0) {
			if (keyType == 2) {
				String value1 = data1.get(key).toString();
				String value2 = data2.get(key).toString();
				return value1.compareTo(value2);
			} else if (keyType == 3) {
				int value1 = Integer.parseInt(data1.get(key).toString());
				int value2 = Integer.parseInt(data2.get(key).toString());
				return value1 < value2 ? -1 : (value1 == value2 ? 0 : 1);
			} else if (keyType == 4) {
				double value1 = Double.parseDouble(data1.get(key).toString());
				double value2 = Double.parseDouble(data2.get(key).toString());
				return value1 < value2 ? -1 : (value1 == value2 ? 0 : 1);
			}
		} else {
			if (keyType == 2) {
				String value1 = data1.get(key).toString();
				String value2 = data2.get(key).toString();
				return value2.compareTo(value1);
			} else if (keyType == 3) {
				int value1 = Integer.parseInt(data1.get(key).toString());
				int value2 = Integer.parseInt(data2.get(key).toString());
				return value1 > value2 ? -1 : (value1 == value2 ? 0 : 1);
			} else if (keyType == 4) {
				double value1 = Double.parseDouble(data1.get(key).toString());
				double value2 = Double.parseDouble(data2.get(key).toString());
				return value1 > value2 ? -1 : (value1 == value2 ? 0 : 1);
			}
		}
		return 0;
	}
}
