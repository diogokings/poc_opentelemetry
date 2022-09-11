package com.location.city;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    private CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

}
