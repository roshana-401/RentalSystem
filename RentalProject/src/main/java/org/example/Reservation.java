package org.example;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservation <T extends Item>{

    Customer customer;
    Library lib;
    Gson write;
    String json;
    FileWriter writer;
    public Reservation(Customer customer, Library lib,Gson write, FileWriter writer)
    {
        this.customer=customer;
        this.lib=lib;
        this.write=write;
        this.writer=writer;
    }
    public void rental(ArrayList<T> item) throws IOException {
        boolean test1 = true;
        for(T oneitem:item)
            System.out.println(oneitem.toString());

        boolean check=true;
        while (test1) {
            if(check==false) {
                for (T items : item)
                    System.out.println(items);
            }
            check=true;
            test1=true;
                SortandSearch<T> sort = new SortandSearch<T>();
                System.out.println("A" + ". Sort by Title");
                System.out.println("B" + ". Sort by Author");
                System.out.println("C" + ". Search");
                System.out.println("D" + ". Back");
                Scanner input = new Scanner(System.in);
                String number2 = input.next();

            if (number2.equalsIgnoreCase("A")==true) {

                sort.sortbyTitle(item);
            }
            if (number2.equalsIgnoreCase("B")==true) {

                sort.sortbyAuthor(item);
            }
            if (number2.equalsIgnoreCase("C")==true) {
                System.out.println("Enter a word to search: ");
                Scanner inputword = new Scanner(System.in);
                String word = inputword.nextLine();
                item = sort.search(item, word);
                if (item.size() == 0) {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Your search result was not found!!!!" + "\n\n");
                    check=false;
                } else {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Results for '" + word + "'");
                    check=false;
                }
            }
            if (number2.equalsIgnoreCase("D")==true) {
                System.out.println("\n\n\n\n");
                test1 = false;
            }
            if (number2.equalsIgnoreCase("A")!=true && number2.equalsIgnoreCase("B")!=true
                                      && number2.equalsIgnoreCase("C")!=true && number2.equalsIgnoreCase("D")!=true) {
                for (int i=0;i<=item.size()-1;i++) {
                    if (item.get(i).getId() == Integer.parseInt(number2)) {
                        if(item.get(i).isAvailable) {
                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println(item.get(i).Title + " item was successfully booked.");
                            RentalStore rent = new RentalStore(lib, write, writer);
                            rent.rentItem(item.get(i), customer);
                            check=false;
                        }else {
                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Item is not available!!!!");
                            check=false;
                        }
                    }
                }

            }
        }
    }
}

