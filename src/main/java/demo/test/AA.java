package demo.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AA {
	public int a;

	public static void main(String[] args) {
		String channelType = "IND_AUTH";
		channelType= "UNEP_"+channelType.substring(0,channelType.lastIndexOf("_"));
		System.out.println(5260*16);

		double value = 0;
		int type = 2;
		switch (type){
			case 1:
				value = type * 1.0;
				break;
			case 2:
				value = type * 2.0;
				break;
			case 3:
				value = type * 3.0;
				break;
		}
		System.out.println(value);
	}

}
