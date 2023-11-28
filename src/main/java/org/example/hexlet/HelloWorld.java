package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.controllers.CoursesController;
import org.example.hexlet.controllers.RootController;
import org.example.hexlet.controllers.UsersController;


public class HelloWorld {
    public static Javalin getApp()  {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get(NamedRoutes.rootPath(), RootController::index);
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);

        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);

        return app;
    }
    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
