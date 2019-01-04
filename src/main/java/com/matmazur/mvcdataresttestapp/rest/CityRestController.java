package com.matmazur.mvcdataresttestapp.rest;

import com.matmazur.mvcdataresttestapp.model.City;
import com.matmazur.mvcdataresttestapp.model.CityWrapper;
import com.matmazur.mvcdataresttestapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityRestController {

    private CityRepository cityRepository;

    @Autowired
    public CityRestController(CityRepository repository) {
        this.cityRepository = repository;
    }

    @GetMapping()
    public ResponseEntity<CityWrapper> getCities() {

        CityWrapper cities = new CityWrapper();
        cities.setCities(cityRepository.findAll());

        if (cities.getCities().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cities);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getCity(@PathVariable Long id) {

        City city = cityRepository.findById(id).orElse(null);

        if (city == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(city);
    }
}
