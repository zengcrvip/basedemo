package demo.test;

import java.util.*;

/**
 * Created by changrong.zeng on 2017/11/15.
 */
public class  T{

    static class Node{
        int value;
        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node node = new Node(0);

        ArrayList<Node> list = new ArrayList<Node>();
        list.add(node);

        ArrayList<Node> list2 = (ArrayList)list.clone();

        if(list.get(0) == list2.get(0)){
            System.out.println("success~~~~~~~~~~~~~~~~~~~");
        }else{
            System.out.println("error~~~~~~~~~~~~~~~~~~~~~");
        }

    }

}