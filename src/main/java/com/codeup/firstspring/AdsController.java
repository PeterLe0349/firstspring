package com.codeup.firstspring;

import com.codeup.firstspring.Models.Ad;
import com.codeup.firstspring.Models.Ads;
import com.codeup.firstspring.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
class AdsController {

    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.

    private AdsRepository adDao;

    public AdsController(AdsRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads2")
    public String index(Model model) {
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post("first ad", "some ad first stuff"));
//        posts.add(new Post("second ad", "some ad second stuff"));
//        model.addAttribute("ads", posts);
//        for(Ad a: adDao.findAll()){
//            System.out.println(a);
//        }
        model.addAttribute("ads", adDao.findAll());
        return "ads2/index";
    }

    @GetMapping("/ads2/create")
    public String createPost() {
        return "/ads2/create";
    }

    @PostMapping("/ads2/create")
    public String createPostPart2(@RequestParam(name = "userid") String userid,@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, Model model) {
        Ads ads = new Ads(Integer.parseInt(userid), title, description);
        adDao.save(ads);
//        System.out.println(title);
//        System.out.println(post.getTitle());
//        System.out.println(post.getBody());
        model.addAttribute("ads", ads);
        return "ads2/index";
    }

    // ...
}