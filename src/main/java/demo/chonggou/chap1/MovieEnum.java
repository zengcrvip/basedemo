package demo.chonggou.chap1;

/**
 * Created by changrong.zeng on 2017/11/27.
 */
public enum MovieEnum {
    CHILDRENS(2),//儿童片
    REGULAR(0), //普通片
    NEW_RELEASE(1); //新片

    private int priceCode;

    MovieEnum(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }
}
