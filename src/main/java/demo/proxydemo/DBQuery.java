package demo.proxydemo;

/**
 * IDBQuery的具体实现类，可能构造时间比较慢，是一个重量级对象
 * @author zengcr
 *
 */
public class DBQuery implements IDBQuery {

	public DBQuery() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String request() {
		return "request string";
	}

}
