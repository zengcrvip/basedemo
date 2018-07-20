package demo.test.packagedemo;

import java.util.*;

/**
 * @Description: 有一个背包，最多放M kg的物体（物体大小不限）；
                 有n个物体，每个物体的重量为Wi，每个物体完全放入背包后可获得收益Pi。问：如何放置能获得最大的收益？
 * @Author: changrong.zeng
 * @Date: Created in 15:47 2018/3/21 .
 */
public class BodyTest {


    /**
     * 一般背包问题的代码实现
     * @param w：每个物体重量的数组
     * @param p：每个物体价值的数组
     * @param m:背包的重量
     * @return
     */
    public  List<Body> commonPackage(int[] w,int[] p,int m)
    {
        List<Body> bodyList = new ArrayList<Body>();
        for(int i=0;i<w.length;i++){
            bodyList.add(new Body(i,w[i],p[i]));
        }


        //倒序
        Collections.sort(bodyList,new Comparator<Body>(){
            @Override
            public int compare(Body o1, Body o2) {
                return o2.getP()/o2.getW() - o1.getP()/o1.getW();
            }
        });

        int rest = m;
        List<Body> packages = new ArrayList<Body>();
        for(Body body : bodyList ){
            if(rest < body.getW()){
                break;
            }
            packages.add(body);
            rest = rest - body.getW();
        }

        return bodyList;


    }

    public static void main(String[] args) {

    }
}
