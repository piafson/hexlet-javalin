package org.example.hexlet;

import io.javalin.Javalin;

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
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("/courses/{id}", ctx -> {
            ctx.result("Course ID: " + ctx.pathParam("id"));
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
            ctx.result("Post ID: " + ctx.pathParam("postId"));
        });
        app.start(7070);
    }
}
