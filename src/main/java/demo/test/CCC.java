package demo.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by changrong.zeng on 2018/1/2.
 */
public class CCC {
    private static  int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};


    public void sort(int a[]){
        for (int i=1;i<a.length;i++){
            int j = i-1;
            int temp = a[i];
            for(;j>=0 && temp < a[j];j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }

    public void sort2(int a[]){
        for(int i=0;i<a.length -1;i++){
            for(int j=0;j<a.length -1 - i;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public void sort3(int a[]){
        for (int i=0;i<a.length;i++){
            int j = i+1;
            int position = i;
            int temp = a[i];
            for(;j<a.length;j++){
               if (a[j] < temp){
                   temp = a[j];
                   position = j;
               }
            }
            a[position] = a[i];
            a[i] = temp;


        }
    }

    public  void sort4(int a[]){
        int low = 0;
        int high = a.length-1;
        quickSort(a,low,high);


    }

    public int getMindle(int[] a,int low,int high){
        int temp = a[low];
        while (low < high){
            while (low < high && a[high] >= temp){
                high --;
            }
            a[low] = a[high];

            while (low < high && a[low] <= temp){
                low ++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }



    public void quickSort(int a[],int low,int high){
        if(low < high){
            int mindle = getMindle(a,low,high);
            quickSort(a,low,mindle);
            quickSort(a,mindle +1,high);
        }
    }

    public static void main(String[] args) {
        CCC ccc = new CCC();
        ccc.sort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] +", ");
        }



    }
}
