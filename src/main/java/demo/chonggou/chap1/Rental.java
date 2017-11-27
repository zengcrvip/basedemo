package demo.chonggou.chap1;

/**
 * 租赁
 * Created by changrong.zeng on 2017/11/27.
 */
public class Rental {
    private Movie movie;
    private int _daysRented;

    public Rental(Movie movie, int _daysRented) {
        this.movie = movie;
        this._daysRented = _daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public void setDaysRented(int _daysRented) {
        this._daysRented = _daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
