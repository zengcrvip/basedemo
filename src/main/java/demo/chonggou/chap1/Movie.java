package demo.chonggou.chap1;

/**
 * 影片
 * Created by changrong.zeng on 2017/11/27.
 * 需求：顾客租了哪些影片，租期多长，根据租期时间和影片类型计算出费用
 *      影片分为3类：儿童片，普通片，新片
 *      为常客计算积分，积分会根据是否为新片有所不同
 */
public class Movie {
    public static final  int CHILDRENS = 2;//儿童片
    public static final  int REGULAR = 0; //普通片
    public static final  int NEW_RELEASE = 1; //新片

    private String _title;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }
}
