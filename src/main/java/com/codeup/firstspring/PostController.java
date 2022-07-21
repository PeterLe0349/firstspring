package com.codeup.firstspring;

import com.codeup.firstspring.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String post(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "/posts";
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("first", "some first stuff"));
        posts.add(new Post("second", "some second stuff"));
//        System.out.println(title);
//        System.out.println(post.getTitle());
//        System.out.println(post.getBody());
        model.addAttribute("posts", posts);
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
        postDao.save(post);
//        System.out.println(title);
//        System.out.println(post.getTitle());
//        System.out.println(post.getBody());
        model.addAttribute("post", post);
        return "posts/index";
    }

}
