package demo.chonggou.chap1;

/**
 * 价格
 * Created by changrong.zeng on 2017/11/27.
 */
public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }


}
