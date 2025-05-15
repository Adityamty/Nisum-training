import java.util.ArrayList;
import java.util.Comparator;

class Movie {
    String title, director, genre;
    int releaseYear;
    double rating;

    Movie(String title, String director, String genre, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + " | " + director + " | " + genre + " | " + releaseYear + " | Rating: " + rating;
    }
}

public class MovieManager {
    private ArrayList<Movie> movies = new ArrayList<>();

    public void addMovie(String title, String director, String genre, int year, double rating) {
        movies.add(new Movie(title, director, genre, year, rating));
    }

    public void displayMovies() {
        movies.forEach(System.out::println);
    }

    public void filterByGenre(String genre) {
        movies.stream().filter(movie -> movie.genre.equalsIgnoreCase(genre)).forEach(System.out::println);
    }

    public void sortMoviesByRating() {
        movies.sort(Comparator.comparingDouble(movie -> -movie.rating));
        displayMovies();
    }

    public static void main(String[] args) {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 8.8);
        manager.addMovie("Titanic", "James Cameron", "Romance", 1997, 7.8);
        manager.displayMovies();
        manager.sortMoviesByRating();
    }
}
