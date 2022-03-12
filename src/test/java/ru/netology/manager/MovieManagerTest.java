package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    public void shouldAddNewMovie() {
        Movie first = new Movie(1, "bloodshot-1", "Бладшот", "Боевик");
        Movie second = new Movie(2, "onward-1", "Вперёд", "Мультфильм");
        Movie third = new Movie(3, "hotel-belgrade-1", "Отель Белград", "Комедия");
        Movie fourth = new Movie(4, "gentlemen-1", "Джентельмены", "Боевик");
        Movie fifth = new Movie(5, "invisible-man-1", "Человек-невидимка", "Ужасы");
        Movie sixth = new Movie(6, "trolls-world-tour-1", "Тролли.Мировой тур", "Мультфильм");
        Movie seventh = new Movie(7, "number-one-1", "Номер один", "Комедия");
        Movie eighth = new Movie(8, "batman-1", "Бэтмэн", "Боевик");

        MovieManager mov = new MovieManager();
        mov.save(first);
        mov.save(second);
        mov.save(third);
        mov.save(fourth);
        mov.save(fifth);
        mov.save(sixth);
        mov.save(seventh);

        mov.save(eighth);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth};
        Movie[] actual = mov.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMoviesInOrder() {
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

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh};
        Movie[] actual = mov.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMovieReverseOrder() {
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

        Movie[] expected = {seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = mov.getLastMovie();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMoviesWhitLimit() {
        Movie first = new Movie(1, "bloodshot-1", "Бладшот", "Боевик");
        Movie second = new Movie(2, "onward-1", "Вперёд", "Мультфильм");
        Movie third = new Movie(3, "hotel-belgrade-1", "Отель Белград", "Комедия");
        Movie fourth = new Movie(4, "gentlemen-1", "Джентельмены", "Боевик");
        Movie fifth = new Movie(5, "invisible-man-1", "Человек-невидимка", "Ужасы");
        Movie sixth = new Movie(6, "trolls-world-tour-1", "Тролли.Мировой тур", "Мультфильм");
        Movie seventh = new Movie(7, "number-one-1", "Номер один", "Комедия");

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