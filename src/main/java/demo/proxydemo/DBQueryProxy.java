package demo.proxydemo;

public class DBQueryProxy implements IDBQuery {
	private DBQuery real = null;
	

	@Override
	public String request() {
		//在真正需要真实对象的时候才创建，创建过程可能比较慢
		if(real == null){
			real = new DBQuery();
		}
		//在多线程模式下，这里返回一个虚假类，类似于future模式
		return real.request();
	}

}
