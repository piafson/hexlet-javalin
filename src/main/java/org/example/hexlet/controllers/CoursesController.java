package org.example.hexlet.controllers;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.util.Collections;
import java.sql.SQLException;

public class CoursesController {
    public static void index(Context ctx) throws SQLException {
        var courses = CourseRepository.getEntities();
        var page = new CoursesPage(courses);
        ctx.render("courses/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var courses = CourseRepository.getEntities();
        Course course = courses.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst()
                .orElse(null);
        if (course == null) {
            throw new NotFoundResponse("Course not found");
        }
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() >= 10, "Описание должно быть не короче 10 символов")
                    .get();
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        }
    }
}
