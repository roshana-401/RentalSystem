package org.example;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Show {
    Customer customer;
    Library lib;
    Gson write;
    String json;
    FileWriter writer;
    public static ArrayList<Item> donation = new ArrayList<Item>();

    public Show(Customer customer, Library lib, Gson write, FileWriter writer) {
        this.customer = customer;
        this.lib = lib;
        this.write = write;
        this.writer = writer;
    }

    public void showitem() throws IOException {
        boolean test = true;
        System.out.println("Today is " + new Date());
        outer1:
        while (test) {
            test = true;
            System.out.println("\n\n");
            System.out.println("1. Games rental");
            System.out.println("2. Movies rental");
            System.out.println("3. Books rental");
            System.out.println("4. View all borrowed Items");
            System.out.println("5. Item Donation");
            System.out.println("6. Back");

            Reservation rent = new Reservation(customer, lib, write, writer);
            Scanner input1 = new Scanner(System.in);
            int nn = input1.nextInt();
            switch (nn) {
                case 1:
                    System.out.println("----------------------**Games**----------------------");
                    rent.rental(lib.getGames());
                    break;

                case 2:
                    System.out.println("----------------------**Movies**----------------------");
                    rent.rental(lib.getMovies());
                    break;

                case 3:
                    System.out.println("----------------------**Books**----------------------");
                    rent.rental(lib.getBooks());
                    break;

                case 4:
                   ViewallborroweItems();
                    break;

                case 5:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("-----------------------------------**DONATED ITEM**-----------------------------------" + "\n\n");
                    donatedItem();
                    break;


                case 6:
                    System.out.println("\n\n\n\n");
                    return;

                default:
                    System.out.println("The number is not allowed!!!!!");
            }
        }
    }
    public void ViewallborroweItems() throws IOException {
        boolean test2 = true;
        Scanner inputString=new Scanner(System.in);
        outer:
        while (test2) {
            test2 = true;

            System.out.println("-----------------------------------**ITEM**-----------------------------------" + "\n\n");
            if (this.customer.getRentals().size() == 0)
                System.out.println("You do not currently have a item reserved!");
            else {
                System.out.println("Number of books borrowed by you: " + customer.getRentals().size() + "\n");
                System.out.println("Enter the ID of the book to return: " + "\n");
                for (Rental rentt : customer.getRentals()) {
                    System.out.println(rentt);
                    System.out.println("\n");
                }
                System.out.println("\n");
                System.out.println("A. List of my returned items ");
            }

            System.out.println("B. Back");
            String inputt = inputString.nextLine();
            if (inputt.equalsIgnoreCase("A") == true) {
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("-----------------------------------**List of my returned items**-----------------------------------");
                if (customer.getReturnItem().size() == 0)
                    System.out.println("You do not currently have a item returned!");
                else {
                    for (Rental returnitem : customer.getReturnItem()) {
                        System.out.println(returnitem.toString());
                    }
                }
                System.out.println("\n");
                System.out.println("A. Back");
                String inputback = inputString.nextLine();
                continue outer;
            }
                if (inputt.equalsIgnoreCase("B") == true)
                    return;
                if(inputt.equalsIgnoreCase("B") != true && inputt.equalsIgnoreCase("A") != true) {
                    for (Rental rr : customer.getRentals()) {
                        if (Integer.parseInt(inputt)==rr.getItem().getId()) {
                            System.out.println(rr.getItem().getTitle() + " item was successfully returned on " + new Date());
                            RentalStore.returnItem(rr,customer);
                            continue outer;
                        }
                    }
                    System.out.println("The number is not allowed!!!!!");
                }
            }
        }

    public void donatedItem() {
        Scanner inputString = new Scanner(System.in);
        if(donation==null)
            donation=new ArrayList<>();

        System.out.println("Enter the item type: ");
        String type = inputString.nextLine();
        if (type.equalsIgnoreCase("Book") == true) {
            System.out.println("Enter the Title of Book Donation: ");
            String title = inputString.nextLine();
            System.out.println("Enter the genre of Book Donation: (Gnere,Genre) ");
            String genre = inputString.nextLine();
            System.out.println("Enter the Author of Book Donation: ");
            String author = inputString.nextLine();
            System.out.println("Enter the publisher of Book Donation:");
            String publisher = inputString.nextLine();
            System.out.println("Enter the BookCover of Book Donation:");
            String cover = inputString.nextLine();
            System.out.println("Enter the ReleaseDate of Book Donation:");
            String date = inputString.nextLine();
            System.out.println("\n\n" + "Thank you for donating " + title);
            int id = lib.getBooks().size() + 1;
            donation.add(new Book(title, author, genre, date, publisher, cover, id));
            System.out.println("A.Back");
            String adad = inputString.nextLine();
        } else if (type.equalsIgnoreCase("Game") == true) {
            System.out.println("Enter the Title of Game Donation: ");
            String title = inputString.nextLine();
            System.out.println("Enter the genre of Game Donation: (Gnere,Genre) ");
            String genre = inputString.nextLine();
            System.out.println("Enter the Author of Game Donation: ");
            String author = inputString.nextLine();
            System.out.println("Enter the manufacturer of Game Donation:");
            String factur = inputString.nextLine();
            System.out.println("Enter the AboutGame of Game Donation:");
            String game = inputString.nextLine();
            System.out.println("Enter the Director of Game Donation:");
            String director = inputString.nextLine();
            System.out.println("Enter the GameRate of Game Donation:");
            double rate = inputString.nextDouble();
            System.out.println("Enter the ReleaseDate of Game Donation:");
            String date = inputString.nextLine();
            System.out.println("\n\n" + "Thank you for donating " + title);
            int id = lib.getGames().size() + 1;
            donation.add(new Game(title, genre, author, factur, date, id, game, director, rate));
            System.out.println("A.Back");
            int adad = inputString.nextInt();
        } else if (type.equalsIgnoreCase("Movie") == true) {
            System.out.println("Enter the Title of Movie Donation: ");
            String title = inputString.nextLine();
            System.out.println("Enter the genre of Movie Donation: (Gnere,Genre) ");
            String genre = inputString.nextLine();
            System.out.println("Enter the Author of Movie Donation: ");
            String author = inputString.nextLine();
            System.out.println("Enter the Director of Movie Donation:");
            String director = inputString.nextLine();
            System.out.println("Enter the Cast of Movie Donation:(cast,cast)");
            String cast = inputString.nextLine();
            System.out.println("Enter the ReleaseDate of Movie Donation:");
            String date = inputString.nextLine();
            System.out.println("\n\n" + "Thank you for donating " + title);
            int id = lib.getMovies().size() + 1;
            donation.add(new Movie(title, genre, author, director, cast, date, id));
            System.out.println("A.Back");
            String reshteh = inputString.nextLine();
        }else
            System.out.println("There is no such item!!!");
    }
}
