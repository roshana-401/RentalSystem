public class Item
{
    private final String Title;
    private String genre;
    private final String releaseDate;
    private boolean isAvailable;
    private final int Id;
    ///////////////////////////////////////////constructor
    public Item()
    {
        this.Title="";
        this.genre="";
        this.releaseDate="";
        this.isAvailable=false;
        this.Id=0;
    }
    public Item(String Title,String genre,String releaseDate,int Id)
    {
        this.Title=Title;
        this.genre=genre;
        this.releaseDate=releaseDate;
        this.isAvailable=false;
        this.Id=Id;
    }
    ////////////////////////////////////////////setters


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    ////////////////////////////////////////////getters

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
    /////////////////////////////////////////////////Method

}
