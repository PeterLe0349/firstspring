package com.codeup.firstspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class MathController {

    @RequestMapping(path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " plus " + number2 +" is " + (number1 + number2) + "!";
    }
}