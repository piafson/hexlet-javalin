package org.example.hexlet.controllers;

import io.javalin.http.Context;
import org.example.hexlet.dto.root.MainPage;

import java.util.Collections;

public class RootController {
    public static void index(Context ctx) {
        var visited = Boolean.valueOf("visited");
        var page = new MainPage(visited);
        ctx.render("index.jte", Collections.singletonMap("page", page));
        ctx.cookie("visited", String.valueOf(true));
    }
}
