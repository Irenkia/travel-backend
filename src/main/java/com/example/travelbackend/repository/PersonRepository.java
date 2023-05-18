package com.example.travelbackend.repository;

import com.example.travelbackend.model.Country;
import com.example.travelbackend.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("persons")
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    //    List<Person> findByNameContaining(String lastName);

    @Query("SELECT p FROM Person p WHERE p.lastName like %?1%")
    List<Person> findByLike(String lastName);

    List<Person> findBylastName(String lastName);

//    Optional<Person> findByName(String lastName);
}
