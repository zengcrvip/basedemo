package demo.chonggou.chap1;

import java.util.Iterator;
import java.util.Vector;

/**
 * 顾客
 * Created by changrong.zeng on 2017/11/27.
 */
public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String _name) {
        this._name = _name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental arg){
        _rentals.addElement(arg);
    }

    public String statement(){
        double totalAmout = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for "+ this.getName() + "\n";
        for(Iterator<Rental> iterator = _rentals.iterator();iterator.hasNext();){
            double thisAmount = 0;
            Rental each = iterator.next();
            switch(each.getMovie().getPriceCode()){
                case Movie.CHILDRENS:
                    thisAmount += 2;
                    if(each.getDaysRented() > 2){
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.REGULAR:
                    thisAmount += 1.5;
                    if(each.getDaysRented() > 3){
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                case  Movie.NEW_RELEASE:
                    thisAmount += 3;
            }
            frequentRenterPoints ++;
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1){
                frequentRenterPoints ++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmout += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmout) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent Renter Points";
        return result;
    }
}
