package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.Collections;
import java.util.List;

public class HelloWorld {
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
            var courses = List.of(
                    new Course("java", "j"),
                    new Course("python", "p")
            );
            var header = "Courses";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = new Course("php", "php_description");
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });
        app.start(7070);
    }
}
