package org.example.hexlet.repository;

import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {
    private static List<Course> entities = new ArrayList<Course>();

    public static void save(Course user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<Course> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return users;
    }

    public static Optional<Course> find(Long id) {
        var user = entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny()
                .orElse(null);
        return Optional.of(user);
    }

    public static void delete(Long id) {

    }

    public static List<Course> getEntities() {
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
