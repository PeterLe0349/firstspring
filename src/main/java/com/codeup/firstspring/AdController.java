package com.codeup.firstspring;

import com.codeup.firstspring.Models.Ad;
import com.codeup.firstspring.Models.Post;
import com.codeup.firstspring.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
class AdController {

    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.

    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post("first ad", "some ad first stuff"));
//        posts.add(new Post("second ad", "some ad second stuff"));
//        model.addAttribute("ads", posts);
//        for(Ad a: adDao.findAll()){
//            System.out.println(a);
//        }
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/create")
    public String createPost() {
        return "/ads/create";
    }


    @PostMapping("/ads/create")
    public String createPostPart2(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, Model model) {
        User u = new User();
        u.setId(1);
        Ad ad = new Ad(title, description,u);
        adDao.save(ad);
//        System.out.println(title);
//        System.out.println(post.getTitle());
//        System.out.println(post.getBody());
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }
}