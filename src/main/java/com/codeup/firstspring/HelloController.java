package com.codeup.firstspring;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @GetMapping("/roll-dice")
    public String roll(){
        return "roll-dice";
    }

    @RequestMapping(path = "/roll-dice/{number1}", method = RequestMethod.GET)
    @ResponseBody
    public String rollDice(@PathVariable String number1) {
        return rollRandom(number1) + rollRandom(number1) +rollRandom(number1);
    }

    public String rollRandom(String a){
        int ran = (int)Math.floor((Math.random()*6)+1);
        int aa = Integer.parseInt(a);
        if(aa==ran){
            return "You rolled a " + a + ". Dice roll was: " + ran +"."  + "Congratulations you win!<br>";
        }else {
            return "You rolled a " + a + ". Dice roll was: " + ran +"."  + "Boohooo. You lose!<br>";
        }

    }

    @GetMapping("/welcome")
    public String welcome1() {
        return "welcome";
    }

    @GetMapping("/hello")
    public String welcome() {
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }
}
