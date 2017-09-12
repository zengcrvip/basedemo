package demo.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;

public class AA {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		
		System.out.println(String.join("-", list));
		
		
		

	}

}
