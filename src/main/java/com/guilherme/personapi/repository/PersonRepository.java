package com.gilberto.apirestproject.repository;

import com.ggilberto.apirestproject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
