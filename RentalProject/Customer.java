import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Customer
{
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String Address;
    private List<Rental> rentals;
    private final int CustomerID;
    //////////////////////////////////////////////////constructor
    public Customer(String name, String phoneNumber,String email,String Address,int Id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email=email;
        this.Address=Address;
        this.CustomerID = Id;
        rentals=new ArrayList<Rental>();
    }
    /////////////////////////////////////////////////setters
    public void setRentals(Rental rentals) {
        this.rentals.add(rentals);
        rentals.setRentaldate(new Date());
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

}
