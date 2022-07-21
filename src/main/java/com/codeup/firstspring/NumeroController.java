package com.codeup.firstspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumeroController {
    private final NumeroRepository numeroDao;

    public NumeroController(NumeroRepository numeroDao){
        this.numeroDao = numeroDao;
    }

    @GetMapping("/numero")
    public String numero(Model model){
        model.addAttribute("numeros", numeroDao.findAll());
        return ("/numero/index.html");
    }

    @GetMapping("/google")
    public String google(){
        return ("redirect:/numero");
    }
}
