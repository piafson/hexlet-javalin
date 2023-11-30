package org.example.hexlet;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }
    public static String usersPath() {
        return "/u";
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    public static String coursesPath() {
        return "/courses";
    }

    public static String buildCoursePath() {
        return "/courses/build";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    public static String sessionsPath() {
        return "/sessions/build";
    }
}
