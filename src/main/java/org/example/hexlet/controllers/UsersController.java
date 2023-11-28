package org.example.hexlet.controllers;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.util.Collections;
import java.util.List;

public class UsersController {
    public static void index(Context ctx) {
        List<User> users = UserRepository.getEntities();
        var page = new UsersPage(users);
        ctx.render("users/index.jte", Collections.singletonMap("page", page));
    }
    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
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
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(firstName, lastName, email, e.getErrors());
            ctx.render("users/build.jte", Collections.singletonMap("page", page)).status(422);
        }
    }
}
