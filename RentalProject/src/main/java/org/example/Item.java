package org.example;

public class Item
{
    protected final String Title;
    protected final String genre;
    protected final String Author;
    protected final String releaseDate;
    protected boolean isAvailable;
    protected final int Id;
    ///////////////////////////////////////////constructor
    public Item()
    {
        Author = "";
        this.Title="";
        this.genre="";
        this.releaseDate="";
        this.isAvailable=false;
        this.Id=0;
    }
    public Item(String Title, String genre, String author, String releaseDate, int Id)
    {
        this.Title=Title;
        this.genre=genre;
        Author = author;
        this.releaseDate=releaseDate;
        this.isAvailable=false;
        this.Id=Id;
    }
    ////////////////////////////////////////////setters


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    ////////////////////////////////////////////getters


    public String getAuthor() {
        return Author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return Title;
    }

    public String getGenre() {
        return genre;
    }

    public int getId() {
        return Id;
    }
    //---------------------------------------------------------------Method
    public String Available()
    {
        if(this.isAvailable)
            return " Available to borrow";
        else
            return "Recently borrowed";
    }

}
