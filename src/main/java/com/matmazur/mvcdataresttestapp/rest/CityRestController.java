package com.matmazur.mvcdataresttestapp.rest;

import com.matmazur.mvcdataresttestapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityRestController {

    private final
    CityRepository cityRepository;

    @Autowired
    public CityRestController(CityRepository repository) {
        this.cityRepository = repository;
    }

}
