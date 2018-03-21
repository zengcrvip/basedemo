package demo.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class AA {
	public int a;

	public static void main(String[] args) {
		AA aa = new AA();
		System.out.println(AA.String_length("aB123"));

	}


	private static int String_length(String value) {
		int valueLength = 0;
		String chinese = "[\u4e00-\u9fa5]";
		for (int i = 0; i < value.length(); i++) {
			String temp = value.substring(i, i + 1);
			if (temp.matches(chinese)) {
				valueLength += 3;
			} else {
				valueLength += 1;
			}
		}
		return valueLength;
	}


}
