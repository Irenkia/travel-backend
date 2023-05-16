package com.example.travelbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "capital")
    private String capital;

    @Column(name = "region")
    private String region;

    public Country(String name, String capital, String region) {
        this.name = name;
        this.capital = capital;
        this.region = region;
    }
}
