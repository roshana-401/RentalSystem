import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalStore
{
    private List<Movie>movies=new ArrayList<Movie>();
    private List<Customer>customers=new ArrayList<Customer>();

    public void register(Customer customer)
    {
        this.customers.add(customer);
    }
    public void addMovie(Movie movie)
    {
        this.movies.add(movie);
    }
    public void removeMovie(Movie movie)
    {
        this.movies.remove(movie);
    }
    public List<Movie> getAvailableMovies()
    {
        return movies;
    }
    public void rentMovie(Movie movie, Customer customer)
    {
        customer.setRentals(new Rental(customer,movie,movie.getId()));
        for (Movie mm:movies) {
             if(mm.getId()==movie.getId())
                 this.movies.remove(movie);
        }
        movie.setAvailable(false);
    }
    public void returnMovie(Rental rental)
    {

        Customer cc=rental.getCustomer();
        for (Rental rr : cc.getRentals()) {
            if(rr.getId()==rental.getId())
                cc.getRentals().remove(rental);

        }
        rental.setReturndate(new Date());
        rental.getMovie().setAvailable(true);
        movies.add(rental.getMovie());
    }
    public Customer getCustomerById(int Id)
    {
        for (Customer cc:customers) {
            if(cc.getCustomerID()==Id)
                return cc;
        }
        return null;
    }
    public Movie getMovieById(int Id)
    {
        for (Movie mm:movies) {
            if(mm.getId()==Id)
                return mm;
        }
        return null;
    }
}
