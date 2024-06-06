package ru.netology.MovieManager;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private String[] movies;
    private final int limit;
    private int size;

    public MovieManager() {
        this(5);
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new String[10];
        this.size = 0;
    }

    public void addMovie(String movie) {
        if (size == movies.length) {
            expandArray();
        }
        movies[size] = movie;
        size++;
    }

    public String[] findAll() {
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = movies[i];
        }
        return result;
    }


    public String[] findLast() {
        int resultLength = Math.min(size, limit);
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[size - 1 - i];
        }
        return result;
    }

    public void updateMovie(int index, String newTitle) {
        if (index >= 0 && index < size) {
            movies[index] = newTitle;
        } else {
            throw new IndexOutOfBoundsException("Invalid movie index");
        }
    }

    public void deleteMovie(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                movies[i] = movies[i + 1];
            }
            movies[size - 1] = null;
            size--;
        } else {
            throw new IndexOutOfBoundsException("Invalid movie index");
        }
    }

    private void expandArray() {
        String[] newArray = new String[movies.length * 2];
        System.arraycopy(movies, 0, newArray, 0, movies.length);
        movies = newArray;
    }
}

public class MovieManager {

        private final List<String> movies = new ArrayList<>();
        private final int limit;


        public MovieManager() {
            this.limit = 5;
        }


        public MovieManager(int limit) {
            this.limit = limit;
        }


        public void addMovie(String movie) {
            movies.add(movie);
        }


        public List<String> findAll() {
            return new ArrayList<>(movies);
        }


        public List<String> findLast() {
            int resultLength = Math.min(movies.size(), limit);

            List<String> result = new ArrayList<>(resultLength);
            for (int i = 0; i < resultLength; i++) {
                result.add(movies.get(movies.size() - 1 - i));
            }
            return result;
        }
    }
