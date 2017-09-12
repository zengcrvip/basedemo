package demo.test;

public class Test {
    Person11 person = new Person11("Test");
    static{
        System.out.println("test static");
    }
     
    public Test() {
        System.out.println("test constructor");
    }
     
    public static void main(String[] args) {
        new MyClass();
    }
}
 
class Person11{
    static{
        System.out.println("person static");
    }
    public Person11(String str) {
        System.out.println("person "+str);
    }
}
 
 
class MyClass extends Test {
    Person11 person = new Person11("MyClass");
    static{
        System.out.println("myclass static");
    }
     
    public MyClass() {
        System.out.println("myclass constructor");
    }
}