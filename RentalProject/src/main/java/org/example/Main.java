package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {

        //-------------------------------------------READ FROM GSON
        Gson gson = new Gson();
        Reader reader = new FileReader("D:\\NIT\\Jozve\\Ostad Maqsudi\\Project\\RentalSystem\\RentalProject\\src\\test\\TestYourFork.json"); // open the input file
        Library lib = gson.fromJson(reader, new TypeToken<Library>() {

        }.getType());
        reader.close();
        //--------------------------------------------WRITE FROM GSON
        Gson write = new Gson();
        String filePath = "D:\\NIT\\Jozve\\Ostad Maqsudi\\Project\\RentalSystem\\RentalProject\\src\\test\\output.json";

        try {
            FileWriter writer = new FileWriter(filePath);

            //-------------------------------------------------RENTAL

            Book bookJohn1 = lib.getBooks().get(3);
            Book bookJohn2 = lib.getBooks().get(6);
            Book bookemily1 = lib.getBooks().get(1);
            Book bookemily2 = lib.getBooks().get(7);
            Book bookmichael1 = lib.getBooks().get(9);
            Book bookmichael2 = lib.getBooks().get(4);

            RentalStore rent = new RentalStore(lib, write, writer);

            for (Customer cc : lib.getCustomers()) {
                if (cc.getCustomerID() == 1) {
                    rent.rentItem(bookJohn1, cc);
                    cc.getRentals().get(0).setRentaldate(new Date(2023, 2, 11));
                    rent.rentItem(bookJohn2, cc);
                    cc.getRentals().get(1).setRentaldate(new Date(2023, 3, 2));
                } else if (cc.getCustomerID() == 2) {
                    rent.rentItem(bookemily1, cc);
                    cc.getRentals().get(0).setRentaldate(new Date(2023, 6, 1));
                    rent.rentItem(bookemily2, cc);
                    cc.getRentals().get(1).setRentaldate(new Date(2023, 5, 3));
                } else if (cc.getCustomerID() == 3) {
                    rent.rentItem(bookmichael1, cc);
                    cc.getRentals().get(0).setRentaldate(new Date(2023, 5, 6));
                    rent.rentItem(bookmichael2, cc);
                    cc.getRentals().get(1).setRentaldate(new Date(2023, 4, 2));
                }
            }
            //----------------------------------------------------------------------------------LIBRARY
            boolean test = true;
            outer:
            while (test) {
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                test = true;
                System.out.println("Welcom to our Library" + "\n\n");
                System.out.println("1. Manager");
                System.out.println("2. Member");
                System.out.println("3. Exit");

                Scanner inputint = new Scanner(System.in);
                Scanner inputString = new Scanner(System.in);

                int start = inputint.nextInt();

                switch (start) {

                    case 1:
                        boolean check = loginManager(lib);
                        inn:
                        while (check) {

                            check = true;
                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("-----------------------------------**MANAGER**-----------------------------------" + "\n\n");
                            System.out.println("Welcom " + lib.getLibraryManager().getName());
                            System.out.println("Today is " + new Date());
                            System.out.println("\n\n");
                            System.out.println("1. Manager Items");
                            System.out.println("2. Manage Members");
                            System.out.println("3. Donated Items");
                            System.out.println("4. Exit");
                            int adad = inputint.nextInt();

                            switch (adad) {
                                case 1:

                                    boolean check1 = true;
                                    outer2:
                                    while (check1 == true) {

                                        check1 = true;
                                        String numbercheck = ManagerItem(lib);

                                        switch (numbercheck) {
                                            case "A":
                                            case "a":
                                                RemoveItem(lib, write, writer);
                                                break;

                                            case "B":
                                            case "b":
                                                check1 = false;
                                                break;
                                        }
                                    }
                                    break;

                                case 2:
                                    boolean check2 = true;
                                    ManageMember(lib);
                                    break;

                                case 3:
                                    DonatedItem(rent);
                                    break;

                                case 4:
                                    continue outer;

                                default:
                                    System.out.println("The number is not allowed!!");
                                    break;
                            }
                        }
                        break;

                    case 2:
                        boolean test2=true;
                        while(test2) {
                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("-----------------------------------**MEMBER**-----------------------------------" + "\n\n");

                            System.out.println("1. Register");
                            System.out.println("2. Log in");
                            System.out.println("3. Back");

                            Scanner input = new Scanner(System.in);
                            int number = input.nextInt();
                            Show show;

                            switch (number) {

                                case 1:
                                    Register(lib, write, writer);
                                    show = new Show(lib.getCustomers().get(lib.getCustomers().size() - 1), lib, write, writer);
                                    show.showitem();
                                    break;

                                case 2:
                                    login(lib, write, writer);
                                    break;

                                case 3:
                                    continue outer;

                                default:
                                    System.out.println("The number is not allowed!!");
                                    break;
                            }
                        }
                        break ;

                    case 3:
                        writer.close();
                        System.out.println("Good Bye :)");
                        System.out.println("JSON data has been written to the file successfully.");
                        test=false;
                        break ;
                }

            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }

    public static boolean loginManager(Library lib) {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        boolean check = true;
        boolean test = true;

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while (check) {
            check=true;
            System.out.println("-----------------------------------**LOGIN MANAGER**-----------------------------------" + "\n\n");

            System.out.println("Enter your Name: (Enter 0 for back)");
            String name = inputString.nextLine();
            if (name.equalsIgnoreCase("0")==true) {
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                return false;
            }
            System.out.println("Enter your ManagerID: ");
            int id = inputInt.nextInt();

            if (id != lib.getLibraryManager().getManagerID()) {
                System.out.println("The ID is incorrect!!!!");

            } else if (check) {
                if (lib.getLibraryManager().getName().equalsIgnoreCase(name) == true) {

                    return true;
                } else
                    System.out.println("Wrong username!!" + "\n\n");
            }
        }
        return true;
    }
    public static String ManagerItem(Library lib) {
        Scanner inputInt=new Scanner(System.in);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-----------------------------------**MANAGER ITEMS**-----------------------------------"+"\n\n");

        System.out.println("                       -------------**Games**-------------");
        for (Game game : lib.getGames())
            System.out.println(game.toString());
        System.out.println("\n");

        System.out.println("                       -------------**Movies**-------------");
        for (Movie movie : lib.getMovies())
            System.out.println(movie.toString());
        System.out.println("\n");

        System.out.println("                       -------------**Books**-------------");
        for (Book book : lib.getBooks())
            System.out.println(book.toString());
        System.out.println("\n\n");

        System.out.println("A. Remove Item");
        System.out.println("B. Back");
        String number = inputInt.nextLine();
        return number;
    }
    public static void ManageMember(Library lib)
    {
        Scanner inputString=new Scanner(System.in);
        boolean check=true;

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while (check) {
            System.out.println("-----------------------------------**MANAGE MEMBER**-----------------------------------" + "\n\n");

            System.out.println("Enter the customer ID to see the list of reservations: ");
            System.out.println("\n\n");
            for (Customer cc : lib.getCustomers())
                System.out.println(cc.toString());

            System.out.println("A.Back");
            String word = inputString.nextLine();

            if (word.equalsIgnoreCase("A") == true)
                return ;

            else {

                for (Customer cc : lib.getCustomers())
                    if (word.equalsIgnoreCase(String.valueOf(cc.getCustomerID())) == true) {
                        if (cc.getRentals().size() == 0)
                            System.out.println("This member has no reservations");
                        else {
                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("------------------**"+cc.getName()+"**------------------"+"\n\n");
                            for (Rental rr : cc.getRentals())
                                System.out.println(rr.toString());
                        }
                        System.out.println("\n"+"A.Back");
                        word = inputString.nextLine();
                        if (word.equalsIgnoreCase("A") == true) {
                            return ;
                        } else
                            System.out.println("The character is not allowed!!");
                    }
            }
        }
    }
    public static void DonatedItem(RentalStore rent) throws IOException {
        Scanner inputString = new Scanner(System.in);
        Scanner inputint = new Scanner(System.in);

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-----------------------------------**DONATED ITEM**-----------------------------------" + "\n\n");

        boolean test1=true;

        inner:
        while (test1=true) {
            if (Show.donation== null) {
                System.out.println("No Items have been donated yet!!!" + "\n\n");
                System.out.println("A.Back");
                String number2 = inputString.nextLine();
                if (number2.equalsIgnoreCase("A")==true)
                {
                    test1=false;
                    break ;
                }else
                    System.out.println("The character is not allowed!!");
            } else {
                System.out.println("Choose a Item to add to the library: (Enter 0 to delete all items)" + "\n\n");
                for (Item i : Show.donation) {
                    if (i instanceof Movie)
                        System.out.println("Movie: " + ((Movie) i).toString());
                    if (i instanceof Game)
                        System.out.println("Game: " + ((Game) i).toString());
                    if (i instanceof Book)
                        System.out.println("Book: " + ((Book) i).toString());
                }

                System.out.println("A.Back");
                String number = inputString.nextLine();
                if (number.equalsIgnoreCase("A")==true)
                {
                    test1=false;
                    break ;
                }
                if (number.equalsIgnoreCase("0") == true) {
                    Show.donation = null;
                    continue inner;
                } else {
                    for (Item item : Show.donation)
                        if (number.equalsIgnoreCase(String.valueOf(item.getId())) == true && number.equalsIgnoreCase("0") != true) {
                            rent.addItem(item);
                            System.out.println("The book has been successfully added to the library ");
                            continue inner;
                        }
                }
                System.out.println("The character is not allowed!!");
            }
        }
    }
    public static void RemoveItem(Library lib, Gson write, FileWriter writer) throws IOException {
        Scanner inputString = new Scanner(System.in);
        Scanner inputint = new Scanner(System.in);

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-----------------------------------**VIEW ALL ITEM**-----------------------------------" + "\n\n");

        System.out.println("                       -------------**Games**-------------");
        for (Game game : lib.getGames())
            System.out.println(game.toString());
        System.out.println("\n");

        System.out.println("                       -------------**Movies**-------------");
        for (Movie movie : lib.getMovies())
            System.out.println(movie.toString());
        System.out.println("\n");

        System.out.println("                       -------------**Books**-------------");
        for (Book book : lib.getBooks())
            System.out.println(book.toString());
        System.out.println("\n\n");

        String ss;
        boolean check = true;
        do {
            System.out.println("Enter the item type:(Enter 0 for back) ");
            ss = inputString.nextLine();
            if (ss.equalsIgnoreCase("Book") != true && ss.equalsIgnoreCase("Game") != true && ss.equalsIgnoreCase("Movie") != true && ss.equalsIgnoreCase("0") != true) {
                System.out.println("There is no such item!!!!" + "\n\n");

            } else if (ss.equalsIgnoreCase("0") == true) {
                return;
            } else
                check = false;

        } while (check == true);
        check = true;
        System.out.println("Enter the " + ss + " ID: ");
        int ID = inputint.nextInt();

        if (ss.equalsIgnoreCase("Game") == true) {
            for (Game gg : lib.getGames()) {
                if (gg.getId() == ID) {
                    RentalStore remove = new RentalStore(lib, write, writer);
                    remove.removeItem(gg);
                    System.out.println(gg.Title + " Game Removed successfully");
                    check = false;
                    break;
                }
            }
        }

        if (ss.equalsIgnoreCase("Book") == true) {
            for (Book bb : lib.getBooks()) {
                if (bb.getId() == ID) {
                    RentalStore remove = new RentalStore(lib, write, writer);
                    remove.removeItem(bb);
                    System.out.println(bb.Title + " Book Removed successfully");
                    check=false;
                    break ;
                }
            }
        }

        if (ss.equalsIgnoreCase("Movie") == true) {
            for (Movie mm : lib.getMovies()) {
                if (mm.getId() == ID) {
                    RentalStore remove = new RentalStore(lib, write, writer);
                    remove.removeItem(mm);
                    System.out.println(mm.Title + " Movie Removed successfully");
                    check=false;
                    break ;
                }
            }
        }

        String ii;
        if (check==true)
            System.out.println("There is no Movie with this ID");

        System.out.println("A.Back");
        ii = inputString.nextLine();
    }
    public static void Register(Library lib, Gson write, FileWriter writer) throws IOException {

        RentalStore register=new RentalStore(lib,write,writer);
        Scanner inputstring = new Scanner(System.in);

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-----------------------------------**REGISTER**-----------------------------------"+"\n\n");
        System.out.println("Enter your Name: (Enter 0 for back)");
        String name = inputstring.nextLine();
        if(name.equalsIgnoreCase("0")==true)
            return;

        System.out.println("Enter your PhoneNumber: ");
        String phone = inputstring.nextLine();

        System.out.println("Enter your email: ");
        String email = inputstring.nextLine();

        System.out.println("Enter your Address: ");
        String address=inputstring.nextLine();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        int size = lib.getCustomers().size();
        register.register(new Customer(name, phone, email, address, lib.getCustomers().get(lib.getCustomers().size()-1).getCustomerID() + 1));

        System.out.println("\n\n\n" + "Welcom " + name);
        System.out.println("Your CoustomerID is "+(lib.getCustomers().get(lib.getCustomers().size()-1).getCustomerID()+1));
        System.out.println("Don't forget this!!!");
    }

    public static void login(Library lib, Gson write, FileWriter writer) throws IOException {
        RentalStore login = new RentalStore(lib,write,writer);
        boolean check=true;
        Scanner inputInt=new Scanner(System.in);
        Scanner inputString=new Scanner(System.in);

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while(check) {
            check=true;
            System.out.println("-----------------------------------**LOGIN**-----------------------------------" + "\n\n");

            System.out.println("Enter your Name: (Enter 0 for back)");
            String name = inputString.nextLine();
            if(name.equalsIgnoreCase("0")==true)
                return;

            System.out.println("\n\n\n" + "Enter your CustomerID: ");
            int ID = inputInt.nextInt();

            Customer member = login.getCustomerById(ID);

            if (member == null) {
                System.out.println("You are not a member of the library, please register first!!!!" + "\n\n");
            } else {
                if (member.getName().equalsIgnoreCase(name) == true) {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\n\n\n" + "Welcom " + lib.getCustomers().get(ID-1).getName());
                    Show show = new Show(lib.getCustomers().get(ID-1), lib,write,writer);
                    show.showitem();
                    return;
                }
                else
                    System.out.println("You are not a member of the library, please register first!!!!" + "\n\n");
            }
        }
    }
}

