package it.exercise.spring_la_mia_pizzeria_webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Promo;

public interface PromoRepository extends JpaRepository<Promo, Integer>{

}
