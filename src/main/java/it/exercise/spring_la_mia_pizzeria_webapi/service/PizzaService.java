package it.exercise.spring_la_mia_pizzeria_webapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Pizza;
import it.exercise.spring_la_mia_pizzeria_webapi.model.Promo;
import it.exercise.spring_la_mia_pizzeria_webapi.repository.PizzaRepository;
import it.exercise.spring_la_mia_pizzeria_webapi.repository.PromoRepository;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepo;

    @Autowired
    private PromoRepository promoRepo;

    public List<Pizza> findPizza (String name) {

        List<Pizza> result;

        if (name != null && !name.isBlank()) {
            result = pizzaRepo.findByNameContainingIgnoreCase(name);
        } else {
            result = pizzaRepo.findAll();
        }

        return result;
    }

    public Optional<Pizza> findById (Integer id) {

        return pizzaRepo.findById(id);
    }

    public Pizza save(Pizza pizza) {

        return pizzaRepo.save(pizza);
    }

    public void delete (Integer id) {

        Pizza pizza = pizzaRepo.findById(id).get();

        for (Promo p : pizza.getPromos()) {
            promoRepo.deleteById(p.getId());
        }

        pizzaRepo.deleteById(id);
    }
}
