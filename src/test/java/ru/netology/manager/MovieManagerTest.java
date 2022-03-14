package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager mov = new MovieManager();

    private Movie first = new Movie(1, "bloodshot-1", "Бладшот", "Боевик");
    private Movie second = new Movie(2, "onward-1", "Вперёд", "Мультфильм");
    private Movie third = new Movie(3, "hotel-belgrade-1", "Отель Белград", "Комедия");
    private Movie fourth = new Movie(4, "gentlemen-1", "Джентельмены", "Боевик");
    private Movie fifth = new Movie(5, "invisible-man-1", "Человек-невидимка", "Ужасы");
    private Movie sixth = new Movie(6, "trolls-world-tour-1", "Тролли.Мировой тур", "Мультфильм");
    private Movie seventh = new Movie(7, "number-one-1", "Номер один", "Комедия");
    private Movie eighth = new Movie(8, "batman-1", "Бэтмэн", "Боевик");

    @BeforeEach
    public void addMovies() {
        mov.save(first);
        mov.save(second);
        mov.save(third);
        mov.save(fourth);
        mov.save(fifth);
        mov.save(sixth);
        mov.save(seventh);
    }
    @Test
    public void shouldAddNewMovie() {
        mov.save(eighth);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth};
        Movie[] actual = mov.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMoviesInOrder() {

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh};
        Movie[] actual = mov.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMovieReverseOrder() {

        Movie[] expected = {seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = mov.getLastMovie();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMoviesWhitLimit() {
        MovieManager mov = new MovieManager(5);

        mov.save(first);
        mov.save(second);
        mov.save(third);
        mov.save(fourth);
        mov.save(fifth);
        mov.save(sixth);
        mov.save(seventh);

        Movie[] expected = {seventh, sixth, fifth, fourth, third};
        Movie[] actual = mov.getLastMovie();

        assertArrayEquals(expected, actual);
    }
}