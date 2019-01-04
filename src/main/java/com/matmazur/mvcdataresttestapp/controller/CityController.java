package com.matmazur.mvcdataresttestapp.controller;

import com.matmazur.mvcdataresttestapp.model.City;
import com.matmazur.mvcdataresttestapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {

    private CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public String getCities(ModelMap modelMap) {

        List<City> cities = cityRepository.findAll();

        if (!cities.isEmpty()) {
            modelMap.put("cities", cities);
        }
        return "list";
    }

    @PostMapping
    public String saveCity(@ModelAttribute City formCity, RedirectAttributes attributes) {
        if (!formCity.getName().isEmpty()) {
            cityRepository.save(formCity);
            attributes.addFlashAttribute("message", "City has been added");
        }
        return "redirect:/";
    }
}
