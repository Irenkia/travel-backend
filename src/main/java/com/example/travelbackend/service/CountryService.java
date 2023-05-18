package com.example.travelbackend.service;

import com.example.travelbackend.model.Country;
import com.example.travelbackend.repository.CountryRepository;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Qualifier("countries")
@Service
//@Component
//@RequiredArgsConstructor
public class CountryService {
    @Autowired
    private final CountryRepository countryRepository;

    public CountryService(@Qualifier("countries") CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(Integer id) {
        return countryRepository.findById(id);
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(Integer id) {
        countryRepository.deleteById(id);
    }

    public void deleteAllCountries() {
        countryRepository.deleteAll();
    }
}
