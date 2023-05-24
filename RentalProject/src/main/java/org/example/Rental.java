package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rental {
    private Customer customer;
    private Item item;
    private final int Id;
    private  Date rentaldate =null;
    private Date returndate=null;

    public Rental(Customer customer, Item item, int Id) {
        this.customer = new Customer(customer.getName(),customer.getPhoneNumber(),customer.getEmail(),customer.getAddress(),customer.getCustomerID());
        this.item = item;
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

    public Item getItem() {
        return item;
    }

    public int getId() {
        return this.Id;
    }

    public String getRentaldate() {
        if (rentaldate==null)
            return "Has not rentaled yet";
        else
            return (rentaldate+"");
    }

    public String getReturndate() {
        if (returndate==null)
            return "Has not returned yet";
        else
            return (returndate+"");
    }
    public String printReturnItem(){
        if (item instanceof Book)
            return ((Book)item).toString()+"\n"+"\t"+"return by "+customer.getName()+" in "+this.getRentaldate()+" - "+"ReturnDate: "+this.getReturndate();
        else if (item instanceof Game)
            return ((Game)item).toString()+"\n"+"\t"+"return by "+customer.getName()+" in "+this.getRentaldate()+" - "+"ReturnDate: "+this.getReturndate();
        else if (item instanceof Movie)
            return ((Movie)item).toString()+"\n"+"\t"+"return by "+customer.getName()+" in "+this.getRentaldate()+" - "+"ReturnDate: "+this.getReturndate();
        return "";
    }


    @Override
    public String toString()
    {
        if (item instanceof Book)
            return ((Book)item).toString()+"\n"+"\t"+"Booked by "+customer.getName()+" in "+this.getRentaldate()+" - "+"ReturnDate: "+this.getReturndate();
        else if (item instanceof Game)
            return ((Game)item).toString()+"\n"+"\t"+"Booked by "+customer.getName()+" in "+this.getRentaldate()+" - "+"ReturnDate: "+this.getReturndate();
        else if (item instanceof Movie)
            return ((Movie)item).toString()+"\n"+"\t"+"Booked by "+customer.getName()+" in "+this.getRentaldate()+" - "+"ReturnDate: "+this.getReturndate();
        return "";
    }
}