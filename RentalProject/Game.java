public class Game extends Item
{
    private final String publisher;
    private final String  platform;

    /////////////////////////////////////////////////////////////////////////////////////constructor
    public Game(String title,String genre,String publisher,String releaseDate,int id,String platform)
    {
        super(title,genre,releaseDate,id);
        this.publisher=publisher;
        this.platform=platform;
    }
    //////////////////////////////////////////////////////////////////////////////////getters

    public String getPublisher() {
        return publisher;
    }

    public String getPlatform() {
        return platform;
    }
}
