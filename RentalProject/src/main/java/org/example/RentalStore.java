package org.example;

import com.google.gson.Gson;
import org.example.Customer;
import org.example.Item;
import org.example.Rental;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalStore
{
    private static Library lib;
    private static Gson write;
    private static String json;
    private static FileWriter writer;
    private static List<Item>items=new ArrayList<>();
    private static List<Customer>customers;
    public RentalStore(Library lib,  Gson write, FileWriter writer) throws IOException {
        this.lib=lib;
        this.write=write;
        this.writer=writer;
        customers=lib.getCustomers();
        setItems(lib);
    }

    public  void setItems(Library lib) throws IOException {
        for(Game gg:lib.getGames())
            if(gg.isAvailable()==true)
                items.add(gg);
        for(Movie mm:lib.getMovies())
            if(mm.isAvailable()==true)
                items.add(mm);
        for(Book bb:lib.getBooks())
            if(bb.isAvailable()==true)
                items.add(bb);
        json=write.toJson(lib);
        writer.write(json);
    }

    public void register(Customer customer) throws IOException {
        customers.add(customer);
        json=write.toJson(lib);
        writer.write(json);

    }
    public void addItem(Item item) throws IOException {
        this.items.add(item);
        if(item instanceof Game) {
            this.lib.getGames().add((Game) item);
        }
        if (item instanceof Movie) {
            this.lib.getMovies().add((Movie) item);
        }
        if (item instanceof Book) {
            this.lib.getBooks().add((Book) item);
        }
        json=write.toJson(lib);
        writer.write(json);
    }
    public void removeItem(Item item) throws IOException {
        if(items.size()!=0)
          this.items.remove(item);

        if(item instanceof Game) {
            this.lib.getGames().remove((Game) item);
        }
        if (item instanceof Movie) {
            this.lib.getMovies().remove((Movie) item);
        }
        if (item instanceof Book) {
            this.lib.getBooks().remove((Book) item);
        }
        json=write.toJson(lib);
        writer.write(json);
    }
    public List<Item> getAvailableItems()
    {
        return items;
    }
    public static void rentItem(Item item, Customer customer) throws IOException {
        customer.setRentals(new Rental(customer,item, item.getId()));
        if(items.size()!=0) {
            for (int i=0;i<=items.size()-1;i++) {
                if (items.get(i).getId() == item.getId())
                    items.remove(item);
            }
        }

        item.setAvailable(false);
        json=write.toJson(lib);
        writer.write(json);
    }
    public static void returnItem(Rental rental,Customer costomer) throws IOException {

        costomer.getRentals().remove(rental);
        rental.setReturndate(new Date());
        costomer.setReturnItem(rental);
        items.add(rental.getItem());
        rental.getItem().setAvailable(true);
        json=write.toJson(lib);
        writer.write(json);
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
