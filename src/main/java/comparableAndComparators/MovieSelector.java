package comparableAndComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieSelector {
  public static void main(String[] args) {
    Movie movie1 = new Movie("Inception", "Christopher Nolan", 8.8, new java.util.Date(110, 6, 16));
    Movie movie2 =
        new Movie("The Dark Knight", "Christopher Nolan", 9.0, new java.util.Date(108, 6, 18));
    Movie movie3 =
        new Movie("Interstellar", "Christopher Nolan", 8.6, new java.util.Date(114, 10, 7));

    var listOfMovies = new ArrayList<>(List.of(movie1, movie2, movie3));
    System.out.println(listOfMovies);
    // By Default all movies will be added based on movie name in ascending order
    Collections.sort(listOfMovies);
    System.out.println("After sorting");
    System.out.println(listOfMovies);
    // We need custom sorting based on rating
    Collections.sort(listOfMovies, (a, b) -> Double.compare(b.rating(), a.rating()));
    listOfMovies.sort((a, b) -> Double.compare(b.rating(), a.rating()));
    listOfMovies.stream().sorted((a, b) -> Double.compare(b.rating(), a.rating()));
    System.out.println("After sorting based on rating");
    System.out.println(listOfMovies);
  }
}
