package comparableAndComparators;

import java.util.Date;

public record Movie(String movieName, String director, double rating, Date releaseDate)
    implements Comparable<Movie> {

  @Override
  public int compareTo(Movie movie) {
    return this.movieName.compareTo(movie.movieName);
  }
}
