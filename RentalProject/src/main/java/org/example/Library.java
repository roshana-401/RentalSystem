package org.example;

import java.util.ArrayList;

public class Library
{

    private ArrayList<Movie> movies=new ArrayList<Movie>();
    private ArrayList<Game>games=new ArrayList<Game>();
    private ArrayList<Customer>customers=new ArrayList<Customer>();
    private ArrayList<Book>books=new ArrayList<Book>();
    private   Manager LibraryManager;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public void setCustomers(ArrayList<Customer> customers) {
//
        this.customers=customers;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setLibraryManager(Manager libraryManager) {
        LibraryManager = libraryManager;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Manager getLibraryManager() {
        return LibraryManager;
    }
}
