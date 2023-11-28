package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

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
            List<Course> courses = CourseRepository.getEntities();
            var page = new CoursesPage(courses);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/build", ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/courses", ctx -> {
            try {
                var name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                        .get();
                var description = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() >= 10, "Описание должно быть не короче 10 символов")
                        .get();
                var course = new Course(name, description);
                CourseRepository.save(course);
                ctx.redirect("/courses");
            } catch (ValidationException e) {
                var name = ctx.formParam("name");
                var description = ctx.formParam("description");
                var page = new BuildCoursePage(name, description, e.getErrors());
                ctx.render("courses/build.jte", Collections.singletonMap("page", page));
            }
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            List<Course> courses = CourseRepository.getEntities();
            Course course = courses.stream()
                    .filter(u -> id.equals(u.getId()))
                    .findFirst()
                    .orElse(null);
            if (course == null) {
                throw new NotFoundResponse("Course not found");
            }
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users/build", ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/users", ctx -> {
            var firstName = StringUtils.capitalize(StringUtils.strip(ctx.formParam("firstName")));
            var lastName = StringUtils.capitalize(StringUtils.strip(ctx.formParam("lastName")));
            var email = StringUtils.strip(ctx.formParam("email")).toLowerCase();
            try {
                 var passwordConfirmation = ctx.formParam("passwordConfirmation");
                 var password = ctx.formParamAsClass("password", String.class)
                         .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                         .get();
                 var user = new User(firstName, lastName, email, password);
                 UserRepository.save(user);
                 ctx.redirect("/users");
            } catch (ValidationException e) {
                var page = new BuildUserPage(firstName, lastName, email, e.getErrors());
                ctx.render("users/build.jte", Collections.singletonMap("page", page)).status(422);
            }
        });
        app.start(7070);
    }
}
