class Movie extends Item
{
    private final String director;
    private final String cast;
    /////////////////////////////////////////////////////////////////constructor
    public Movie(String title,String genre,String director,String cast,String releaseDate,int id)
    {
        super(title,genre,releaseDate,id);
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

}

