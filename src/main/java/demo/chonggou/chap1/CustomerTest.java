package demo.chonggou.chap1;

/**
 * 测试类
 * Created by changrong.zeng on 2017/11/27.
 */
public class CustomerTest {
    public static void main(String[] args){
        Movie movie1 = new Movie("儿童想象记",2);
        Movie movie2 = new Movie("普通片",0);
        Movie movie3 = new Movie("新书上映",1);

        Rental rental1 = new Rental(movie1,2);
        Rental rental2 = new Rental(movie1,3);
        Rental rental3 = new Rental(movie2,3);
        Rental rental4 = new Rental(movie2,4);
        Rental rental5 = new Rental(movie3,1);
        Rental rental6 = new Rental(movie3,2);

        //张三，借了一本儿童书2天，普通书3天，新书1天
        Customer customer1 = new Customer("张三");
        customer1.addRental(rental1);
        customer1.addRental(rental3);
        customer1.addRental(rental5);

        //李四，借了一本儿童书3天，普通书4天，新书2天
        Customer customer2 = new Customer("李四");
        customer2.addRental(rental2);
        customer2.addRental(rental4);
        customer2.addRental(rental6);

        //预计输出：张三，儿童书：2，普通书 1.5 新书 3，总共 6.5；积分：3
        System.out.println( customer1.statement());
        System.out.println("==================分隔符======================");
        //预计输出：李四，儿童书：3.5，普通书 3 新书 3，总共 9.5；积分：4
        System.out.println( customer2.statement());
    }
}
