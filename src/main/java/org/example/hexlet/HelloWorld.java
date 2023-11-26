package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

public class HelloWorld {

    private static final List<Course> COURSES = List.of(
            new Course(1,"java", "java course"),
            new Course(2,"python", "python course"),
            new Course(3, "php", "php course")
    );
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            if (name != null) {
                ctx.result("Hello, " + name + "!");
            } else {
                ctx.result("Hello, World!");
            }
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            List <Course> courses;
            if (term == null) {
                courses = COURSES;
            } else {
                courses = COURSES
                        .stream()
                        .filter(u -> StringUtils.startsWithIgnoreCase(u.getName(), term))
                        .toList();
            }
            var page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            Course course = COURSES.stream()
                    .filter(u -> id.equals(u.getId()))
                    .findFirst()
                    .orElse(null);
            if (course == null) {
                throw new NotFoundResponse("Course not found");
            }
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });
        app.start(7070);
    }
}
