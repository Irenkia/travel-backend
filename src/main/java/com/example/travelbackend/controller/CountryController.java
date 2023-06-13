package com.example.travelbackend.controller;

import com.example.travelbackend.model.Country;
import com.example.travelbackend.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dashboard")
//@RequiredArgsConstructor
public class CountryController {
    @Autowired
    private final CountryRepository countryRepository;

    public CountryController(@Qualifier("countries") CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
//    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<List<Country>> getAllCountries(@RequestParam(required = false) String name) {
        try {
            List<Country> countries = new ArrayList<Country>();

            if (name == null)
                countryRepository.findAll().forEach(countries::add);
            else
                countryRepository.findByNameContaining(name).forEach(countries::add);

            if (countries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/countries/{id}")
//    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<Country> getCountryById(@PathVariable("id") Integer id) {
        Optional<Country> countryData = countryRepository.findById(id);

        if (countryData.isPresent()) {
            return new ResponseEntity<>(countryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/countries")
//    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        try {
            Country _country = countryRepository
                    .save(new Country(country.getName(), country.getCapital(), country.getRegion()));
            return new ResponseEntity<>(_country, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/countries/{id}")
//    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<Country> updateCountry(@PathVariable("id") Integer id, @RequestBody Country country) {
        Optional<Country> countryData = countryRepository.findById(id);

        if (countryData.isPresent()) {
            Country _country = countryData.get();
            _country.setName(country.getName());
            _country.setCapital(country.getCapital());
            _country.setRegion(country.getRegion());
            return new ResponseEntity<>(countryRepository.save(_country), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/countries/{id}")
//    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id") Integer id) {
        try {
            countryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/countries")
//    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<HttpStatus> deleteAllCountries() {
        try {
            countryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @GetMapping("/countries/name")
//    public ResponseEntity<List<Country>> findByName(@RequestParam String name) {
//        return new ResponseEntity<List<Country>>(countryRepository.findByName(name), HttpStatus.OK);
//    }

    @GetMapping("/tutorials/name")
    public ResponseEntity<List<Country>> findByName(@RequestParam String name) {
        try {
            List<Country> countries = countryRepository.findByName(name);

            if (countries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/countries/{name}")
//    public String findByName(@PathVariable("name") String name) {
//        Optional<Country> countryData = countryRepository.findByName(name);
//        return countryData.isPresent() ? "exist" : "doesn't exist";
//    }
}
