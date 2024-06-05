package ru.netology.MovieManager;

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