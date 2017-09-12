package demo.nio;

import java.nio.ByteBuffer;

public class BufferCapacityTest {

	public static void main(String[] args) {
		ByteBuffer b = ByteBuffer.allocate(15);
		System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());
		for(int i=0;i<10;i++){
			b.put((byte)i);
		}
		System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());
		b.flip();
		System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());
		for(int i=0;i<5;i++){
			System.out.print(b.get());
		}
		System.out.println();
		System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());
		b.flip();
		System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());

	}

}
