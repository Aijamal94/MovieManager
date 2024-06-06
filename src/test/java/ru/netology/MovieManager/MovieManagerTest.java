package ru.netology.MovieManager;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void testAddAndFindAllMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        String[] expected = {"Movie 1", "Movie 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLastMovies() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");

        String[] expected = {"Movie 4", "Movie 3", "Movie 2"};
        assertArrayEquals(expected, manager.findLast());
    }


    @Test
    public void testUpdateMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        manager.updateMovie(1, "Updated Movie 2");

        String[] expected = {"Movie 1", "Updated Movie 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testDeleteMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        manager.deleteMovie(1);

        String[] expected = {"Movie 1", "Movie 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLastWithDefaultLimit() {
        MovieManager manager = new MovieManager();
=======
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {

    private MovieManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager();
    }

    @Test
    public void testAddMovie() {
        manager.addMovie("Movie 1");
        List<String> movies = manager.findAll();
        assertEquals(1, movies.size());
        assertEquals("Movie 1", movies.get(0));
    }

    @Test
    public void testFindAll() {
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        List<String> movies = manager.findAll();
        assertArrayEquals(new String[]{"Movie 1", "Movie 2", "Movie 3"}, movies.toArray());
    }

    @Test
    public void testFindLastWithDefaultLimit() {
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
        manager.addMovie("Movie 6");
        List<String> movies = manager.findLast();
        assertArrayEquals(new String[]{"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"}, movies.toArray());
    }

    @Test
    public void testFindLastWithCustomLimit() {
        manager = new MovieManager(3);
>>>>>>> acbadec5958dcb98c0b62b21232218ffa0b55d59
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
<<<<<<< HEAD
        manager.addMovie("Movie 6");

        String[] expected = {"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testExpandArray() {
        MovieManager manager = new MovieManager(10);
        for (int i = 1; i <= 20; i++) {
            manager.addMovie("Movie " + i);
        }

        String[] allMovies = manager.findAll();
        assertEquals(20, allMovies.length);
        assertEquals("Movie 1", allMovies[0]);
        assertEquals("Movie 20", allMovies[19]);
    }
}
=======
        List<String> movies = manager.findLast();
        assertArrayEquals(new String[]{"Movie 5", "Movie 4", "Movie 3"}, movies.toArray());
    }

    @Test
    public void testFindLastWhenLessThanLimit() {
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        List<String> movies = manager.findLast();
        assertArrayEquals(new String[]{"Movie 2", "Movie 1"}, movies.toArray());
    }
}
>>>>>>> acbadec5958dcb98c0b62b21232218ffa0b55d59
