package ru.netology.MovieManager;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void testAddAndFindAllMovies() {
        MovieManager1 manager = new MovieManager1();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        String[] expected = {"Movie 1", "Movie 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLastMovies() {
        MovieManager1 manager = new MovieManager1(3);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");

        String[] expected = {"Movie 4", "Movie 3", "Movie 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testUpdateMovie() {
        MovieManager1 manager = new MovieManager1();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        manager.updateMovie(1, "Updated Movie 2");

        String[] expected = {"Movie 1", "Updated Movie 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testUpdateMovieWithValidIndex() {
        MovieManager1 manager = new MovieManager1();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        manager.updateMovie(0, "Updated Movie 1");
        String[] expected = {"Updated Movie 1", "Movie 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testUpdateMovieWithInvalidIndex() {
        MovieManager1 manager = new MovieManager1();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            manager.updateMovie(3, "Invalid Movie");
        });
    }

    @Test
    public void testDeleteMovie() {
        MovieManager1 manager = new MovieManager1();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        manager.deleteMovie(1);

        String[] expected = {"Movie 1", "Movie 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testDeleteMovieWithValidIndex() {
        MovieManager1 manager = new MovieManager1();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        manager.deleteMovie(0);
        String[] expected = {"Movie 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testDeleteMovieWithInvalidIndex() {
        MovieManager1 manager = new MovieManager1();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            manager.deleteMovie(3);
        });
    }

    @Test
    public void testFindLastWithDefaultLimit() {
        MovieManager1 manager = new MovieManager1();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
        manager.addMovie("Movie 6");

        String[] expected = {"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testExpandArray() {
        MovieManager1 manager = new MovieManager1(10);
        for (int i = 1; i <= 20; i++) {
            manager.addMovie("Movie " + i);
        }

        String[] allMovies = manager.findAll();
        assertEquals(20, allMovies.length);
        assertEquals("Movie 1", allMovies[0]);
        assertEquals("Movie 20", allMovies[19]);
    }
}
