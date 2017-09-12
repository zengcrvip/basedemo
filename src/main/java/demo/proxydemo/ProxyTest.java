package demo.proxydemo;

public class ProxyTest {

	public static void main(String[] args) {
		
		IDBQuery  query = new DBQueryProxy();   //使用代理
		query.request();                        //在真正使用时才创建真实对象

	}

}
