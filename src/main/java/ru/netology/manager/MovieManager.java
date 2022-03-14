package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int movieLimit = 10;

    public MovieManager(int movieLimit) {
        this.movieLimit = movieLimit;
    }

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie film) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        movies = tmp;
    }

    public Movie[] getLastMovie() {
        int resultLength;
        if (movies.length <= movieLimit) {
            resultLength = movies.length;
        } else {
            resultLength = movieLimit;
        }
        Movie[] movie = findAll();
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movie[index];
        }
        return result;
    }
}