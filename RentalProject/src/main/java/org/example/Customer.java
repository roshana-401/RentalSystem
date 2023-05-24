package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Customer
{
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String Address;
    private ArrayList<Rental>rentals=new ArrayList<>();
    private ArrayList<Rental>returnItem=new ArrayList<>();
    private final int CustomerID;
    //////////////////////////////////////////////////constructor
    public Customer(String name, String phoneNumber, String email, String Address, int Id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email=email;
        this.Address=Address;
        this.CustomerID = Id;
    }
    /////////////////////////////////////////////////setters
    public void setRentals(Rental rentals) {
          this.rentals.add(rentals);
        rentals.setRentaldate(new Date());
    }

    public void setReturnItem(Rental returnItem) {

        this.returnItem.add(returnItem);
    }
    /////////////////////////////////////////////////getters


    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public ArrayList<Rental> getReturnItem() {
        return returnItem;
    }

    @Override
    public String toString()
    {
        return "Id: "+this.CustomerID+"\n"+"\t  "+"Name: "+this.name+" - "+"Email: "+this.email+" - "+"Phone: "+this.phoneNumber+ " - "+"Address: "+this.Address;
    }

}
