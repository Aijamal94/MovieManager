package ru.netology.MovieManager;

<<<<<<< HEAD
public class MovieManager {
    private String[] movies;
    private final int limit;
    private int size;

    public MovieManager() {
        this(5); // по умолчанию лимит 5
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new String[10]; // начальный размер массива
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
=======
import java.util.ArrayList;
import java.util.List;

public class MovieManager {

        private List<String> movies = new ArrayList<>();
        private int limit;

        // Конструктор без параметров, устанавливающий лимит в 5
        public MovieManager() {
            this.limit = 5;
        }

        // Конструктор с параметром, устанавливающий лимит по переданному значению
        public MovieManager(int limit) {
            this.limit = limit;
        }

        // Метод для добавления нового фильма
        public void addMovie(String movie) {
            movies.add(movie);
        }

        // Метод для получения всех фильмов в порядке добавления
        public List<String> findAll() {
            return new ArrayList<>(movies);
        }

        // Метод для получения последних добавленных фильмов в обратном порядке
        public List<String> findLast() {
            int resultLength = Math.min(movies.size(), limit);

            List<String> result = new ArrayList<>(resultLength);
            for (int i = 0; i < resultLength; i++) {
                result.add(movies.get(movies.size() - 1 - i));
            }
            return result;
        }
    }
>>>>>>> acbadec5958dcb98c0b62b21232218ffa0b55d59
