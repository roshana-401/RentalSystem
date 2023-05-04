import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rental {
    private Customer customer;
    private Item item;
    private final int Id;
    private final Date rentaldate;
    private Date returndate;

    public Rental(Customer customer, Item item, int Id) {
        this.customer = customer;
        this.item = item;
        this.Id = Id;
        rentaldate = new Date();
        returndate= new Date();
        returndate.setDate(rentaldate.getDate() + 14);
    }
    /////////////////////////////////////////////////////////setters

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }
    ///////////////////////////////////////////////////////getters

    public Customer getCustomer() {
        return customer;
    }

    public Item getItem() {
        return item;
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