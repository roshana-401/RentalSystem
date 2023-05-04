import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rental {
    private Customer customer;
    private Movie movie;
    private final int Id;
    private  Date rentaldate;
    private Date returndate;

    public Rental(Customer customer, Movie movie, int Id) {
        this.customer = customer;
        this.movie = movie;
        this.Id = Id;
    }
    /////////////////////////////////////////////////////////setters

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public void setRentaldate(Date rentaldate) {
        this.rentaldate = rentaldate;
    }
    ///////////////////////////////////////////////////////getters

    public Customer getCustomer() {
        return customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getId() {
        return this.Id;
    }

    public Date getRentaldate() {
        return rentaldate;
    }

    public Date getReturndate() {
        return returndate;
    }
    public double calculateLateFee(){

        //Calculate the number of days-----------------
            int daysdiff = 0;
            long diff = rentaldate.getTime() - returndate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            daysdiff = (int) diffDays;
        //Penalty calculation---------------------------
            double penalty=1.5;
            double pay=daysdiff*1.5;
            return pay;
    }
}