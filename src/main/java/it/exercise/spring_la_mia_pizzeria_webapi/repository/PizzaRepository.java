package it.exercise.spring_la_mia_pizzeria_webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

    public List<Pizza> findByNameContainingIgnoreCase(String name);

}
