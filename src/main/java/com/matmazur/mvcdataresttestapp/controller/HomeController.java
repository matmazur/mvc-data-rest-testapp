package com.matmazur.mvcdataresttestapp.controller;

import com.matmazur.mvcdataresttestapp.model.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(ModelMap modelMap) {

        modelMap.put("formCity", new City());
        return "home";
    }
}
