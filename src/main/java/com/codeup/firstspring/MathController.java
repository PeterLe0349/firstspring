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

    @RequestMapping(path = "/subtract/{number1}/rom/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " minus " + number2 +" is " + (number2 - number1) + "!";
    }

    @RequestMapping(path = "/multiply/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " times " + number2 +" is " + (number2 * number1) + "!";
    }

    @RequestMapping(path = "/divide/{number1}/by/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable double number1, @PathVariable double number2) {
        return number1 + " divided by " + number2 +" is " + (number1 / number2) + "!";
    }
}