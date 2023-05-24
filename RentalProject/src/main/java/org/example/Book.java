package org.example;

public class Book extends Item
{
    private final String publisher;
    private final String BookCover;

    ///////////////////////////////////////////////////constructor
    public Book(String Title, String author, String Genre, String releaseDate, String publisher, String bookCover,int Id) {
        super(Title,Genre, author,releaseDate,Id);
        this.publisher=publisher;
        this.BookCover = bookCover;
    }
    //////////////////////////////////////////////////getters

    public String getPublisher() {
        return publisher;
    }

    public String getBookCover() {
        return BookCover;
    }
    @Override
    public String toString()
    {
        return "Id: "+super.Id+"\n"+"\t"+"   Book: "+super.Title+" - "+"Genre: "+super.genre+" - "+"ReleaseDate: "+super.releaseDate+"\n"+
                "\t\t\t\t"+" - "+"Author: "+super.Author+" - "+"Publisher: "+this.publisher+" - "+"BookCover: "+this.BookCover
                +"\n"+"\t\t\t\t\t\t\t\t"+super.Available();
    }
}
