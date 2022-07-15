package com.codeup.firstspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String mainPage() {
        return "Welcome to the main page!";
    }


    @RequestMapping(path = "/posts/{indexnum}", method = RequestMethod.GET)
    @ResponseBody
    public String indexPage(@PathVariable int indexnum) {
        return "Show post: " + indexnum; //retrieve data id and post it
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPost() {
        return "" +
                "<form action=\"/posts/create\" method=\"post\">" +
                "<label for=\"create\">Post info:</label>" +
                "<input type=\"text\" id=\"create\" name=\"create\">" +
                "<button type=\"submit\">Submit</button>" +
                "</form>"; //retrieve data id and post it
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String showPost() {
        return "<h1>Redirect to website with created post </h1>";
        // send to form site
//        // redirect
    }
}
