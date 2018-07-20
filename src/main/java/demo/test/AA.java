package demo.test;


public class AA {
	public int a;

	public static void main(String[] args) throws Exception{
		AA aa = new AA();
		System.out.println(AA.String_length("aB123"));

		try {
			a();
			System.out.println("main===========");
		} catch (Exception e) {
			System.out.println("main catch");
		}


	}

	public static  int a () throws Exception{
		try {
			int x = 10 /0;
			return 0;
		}catch (ArithmeticException e1){
			System.out.println("ArithmeticException");
			throw e1;
		}catch (Exception e) {
			System.out.println("Exception");
			throw e;
		} finally {
			System.out.println("finally");
			return 1;
		}
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
