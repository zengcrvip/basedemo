package demo.chonggou.chap1;

/**
 * Created by changrong.zeng on 2017/11/27.
 */
public class RegularPrice extends Price{
    @Override
    int getPriceCode() {
        return MovieEnum.REGULAR.getPriceCode();
    }

    public double getCharge(int daysRented) {
        double result = 1.5;
        if(daysRented > 3){
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
