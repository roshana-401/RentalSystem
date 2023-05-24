package org.example;

public class Game extends Item
{
    private final String manufacturer;
    private final String  aboutGame;

    private final String director;

    private final double gameRate;

    /////////////////////////////////////////////////////////////////////////////////////constructor
    public Game(String title, String genre,String author, String manufacturer, String releaseDate, int Id, String aboutGame, String director, double gameRate)
    {
        super(title,genre, author, releaseDate,Id);
        this.manufacturer=manufacturer;
        this.aboutGame=aboutGame;
        this.director = director;
        this.gameRate = gameRate;
    }
    //////////////////////////////////////////////////////////////////////////////////getters

    public String getaboutGame() {
        return aboutGame;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public String getDirector() {
        return director;
    }

    public double getGameRate() {
        return gameRate;
    }

    @Override
    public String toString()
    {
        return "Id: "+super.Id+"\n"+"\t"+"   Game: "+super.Title+" - "+"Genre: "+super.genre+" - "+"ReleaseDate: "+super.releaseDate+"\n"+
                 "\t\t\t\t"+" - "+"Author: "+super.Author+" - "+"Director: "+this.director+" - "+"GameRate: "+this.gameRate+"\n"+
                "\t\t\t\t\t\t"+" - "+"AboutGame: "+this.aboutGame+" - "+"Manufacturer: "+this.manufacturer
                +"\n"+"\t\t\t\t\t\t\t\t"+super.Available();
    }
}