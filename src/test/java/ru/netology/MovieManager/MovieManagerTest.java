package ru.netology.MovieManager;

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
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
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
