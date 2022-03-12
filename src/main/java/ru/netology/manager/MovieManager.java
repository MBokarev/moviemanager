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
    private int MovieLimit = 10;

    public MovieManager(int movieLimit) {
        MovieLimit = movieLimit;
    }

    public static void main(String[] args) {
        Movie first = new Movie(1, "bloodshot-1", "Бладшот", "Боевик");
        Movie second = new Movie(2, "onward-1", "Вперёд", "Мультфильм");
        Movie third = new Movie(3, "hotel-belgrade-1", "Отель Белград", "Комедия");
        Movie fourth = new Movie(4, "gentlemen-1", "Джентельмены", "Боевик");
        Movie fifth = new Movie(5, "invisible-man-1", "Человек-невидимка", "Ужасы");
        Movie sixth = new Movie(6, "trolls-world-tour-1", "Тролли.Мировой тур", "Мультфильм");
        Movie seventh = new Movie(7, "number-one-1", "Номер один", "Комедия");

        MovieManager mov = new MovieManager();
        mov.save(first);
        mov.save(second);
        mov.save(third);
        mov.save(fourth);
        mov.save(fifth);
        mov.save(sixth);
        mov.save(seventh);
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
        if (movies.length <= MovieLimit) {
            resultLength = movies.length;
        } else {
            resultLength = MovieLimit;
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