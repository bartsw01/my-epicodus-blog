import models.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
        staticFileLocation("/public");

        //get: show new post form
        get("/posts/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new post form
        post("/posts/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();

            String content = request.queryParams("content");
            Post newPost = new Post(content);
            model.put("post", newPost);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show all posts
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Post> posts = Post.getAll();
            model.put("posts", posts);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual post

        //get: show a form to update a post

        //post: process a form to update a post

        //get: delete an individual post

        //get: delete all posts
    }
}