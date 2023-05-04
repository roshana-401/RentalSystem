public class Book extends Item
{
      private final String author;
      private final String publisher;
      private static int numberBook=1;

      ///////////////////////////////////////////////////constructor
      public Book(String Title, String author, String Genre,String releaseDate,String publisher) {
          super(Title,Genre,releaseDate,numberBook);
          this.author = author;
          this.publisher=publisher;
          numberBook++;
      }
        //////////////////////////////////////////////////getters

    public String getPublisher() {
        return publisher;
    }
    public String getAuthor()
    {
            return author;
    }

}
