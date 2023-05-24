package org.example;

import org.example.Item;

class Movie extends Item
{
    private final String director;
    private final String cast;
    /////////////////////////////////////////////////////////////////constructor
    public Movie(String title,String genre,String author,String director,String cast,String releaseDate,int id)
    {
        super(title,genre, author, releaseDate,id);
        this.director=director;
        this.cast=cast;

    }
    ////////////////////////////////////////////////////////////////getters

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    @Override
    public String toString()
    {
        return "Id: "+super.Id+"\n"+"\t"+"   Movie: "+super.Title+" - "+"Genre: "+super.genre+" - "+"ReleaseDate: "+super.releaseDate+"\n"+
                "\t\t\t\t"+" - "+"Author: "+super.Author+" - "+"Director: "+this.director+" - "+"Cast: "+this.cast
                +"\n"+"\t\t\t\t\t\t\t\t"+super.Available();
    }

}

