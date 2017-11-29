package demo.chonggou.chap1;

/**
 * Created by changrong.zeng on 2017/11/27.
 */
public class ChildrensPrice extends Price {

    @Override
    int getPriceCode() {
        return MovieEnum.CHILDRENS.getPriceCode();
    }

    public double getCharge(int daysRented) {
        double result = 2;
        if(daysRented > 2){
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
