package demo.chonggou.chap1;

/**
 * Created by changrong.zeng on 2017/11/27.
 */
public class NewReleasePrice extends Price{
    @Override
    int getPriceCode() {
        return MovieEnum.NEW_RELEASE.getPriceCode();
    }

    public double getCharge(int daysRented) {
        double result = 3;
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
