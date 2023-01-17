package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WeatherApiRestController {
    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping("/weather")
    private List<Weather> list() {
        return weatherRepository.findAll(Sort.by("id"));
    }

    @PostMapping("/weather")
    private ResponseEntity<Weather> save(@RequestBody Weather weather) {
        Weather save = weatherRepository.save(weather);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/weather/{id}")
    private ResponseEntity<Weather> get(@PathVariable Integer id) {
        Optional<Weather> byId = weatherRepository.findById(id);
        if (!byId.isPresent()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }

    @DeleteMapping("/weather/{id}")
    private ResponseEntity<Object> delete(@PathVariable Integer id) {
        weatherRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
