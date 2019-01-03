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

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {

    private final CityRepository cityRepository;

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
    public String saveCity(@ModelAttribute City formCity, ModelMap modelMap) {
        if (!formCity.getName().isEmpty()) {
            cityRepository.save(formCity);
            modelMap.put("message", "City added");
        }
        return "redirect:/";
    }
}
