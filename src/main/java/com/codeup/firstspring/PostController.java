package com.codeup.firstspring;

import com.codeup.firstspring.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String mainPage() {
        return "Welcome to the main page!";
    }

    @GetMapping("/show")
    public String show() {
        return "posts/show";
    }

    @GetMapping("/index")
    public String index() {
        return "posts/index";
    }


    @RequestMapping(path = "/posts/{indexnum}", method = RequestMethod.GET)
    @ResponseBody
    public String indexPage(@PathVariable int indexnum) {
        return "Show post: " + indexnum; //retrieve data id and post it
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "/posts/create";
    }


    @PostMapping("/posts/create")
    public String createPostPart2(@RequestParam(name = "title") String title,@RequestParam(name = "description") String description, Model model) {
        Post post = new Post(title, description);
//        System.out.println(title);
//        System.out.println(post.getTitle());
//        System.out.println(post.getBody());
        model.addAttribute("post", post);
        return "posts/index";
    }

}