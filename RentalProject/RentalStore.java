import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalStore
{
    private List<Item>items=new ArrayList<Item>();
    private List<Customer>customers=new ArrayList<Customer>();

    public void register(Customer customer)
    {
        this.customers.add(customer);
    }
    public void addItem(Item item)
    {
        this.items.add(item);
    }
    public void removeItem(Item item)
    {
        this.items.remove(item);
    }
    public List<Item> getAvailableItems()
    {
        return items;
    }
    public void rentItem(Item item, Customer customer)
    {
        customer.setRentals(new Rental(customer,item,item.getId()));
        for (Item mm:items) {
             if(mm.getId()==item.getId())
                 this.items.remove(item);
        }
        item.setAvailable(false);
    }
    public void returnItem(Rental rental)
    {

        Customer cc=rental.getCustomer();
        for (Rental rr : cc.getRentals()) {
            if(rr.getId()==rental.getId())
                cc.getRentals().remove(rental);

        }
        rental.setReturndate(new Date());
        rental.getItem().setAvailable(true);
        items.add(rental.getItem());
    }
    public Customer getCustomerById(int Id)
    {
        for (Customer cc:customers) {
            if(cc.getCustomerID()==Id)
                return cc;
        }
        return null;
    }
    public Item getItemById(int Id)
    {
        for (Item mm : items) {
            if(mm.getId()==Id)
                return mm;
        }
        return null;
    }
}
