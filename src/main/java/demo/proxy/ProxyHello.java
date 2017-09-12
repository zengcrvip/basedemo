package demo.proxy;

public class ProxyHello implements IHello {
	private IHello ihello;
	
	public ProxyHello(IHello ihello) {
		super();
		this.ihello = ihello;
	}

	@Override
	public void sayHello() {
		
		ihello.sayHello();

	}

}
