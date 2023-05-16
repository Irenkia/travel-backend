package com.example.travelbackend.repository;

import com.example.travelbackend.model.Country;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Qualifier("countries")
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findByNameContaining(String name);

    //    @Query("SELECT c FROM Country c WHERE c.name like %?1%")
    //    List<Country> findByLike(String capital);

    List<Country> findByName(String name);

//    Optional<Country> findByName(String name);
}

