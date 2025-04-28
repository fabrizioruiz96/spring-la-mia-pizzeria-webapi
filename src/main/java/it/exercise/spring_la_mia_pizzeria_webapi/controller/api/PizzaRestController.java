package it.exercise.spring_la_mia_pizzeria_webapi.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Pizza;
import it.exercise.spring_la_mia_pizzeria_webapi.model.Promo;
import it.exercise.spring_la_mia_pizzeria_webapi.repository.PizzaRepository;
import it.exercise.spring_la_mia_pizzeria_webapi.repository.PromoRepository;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/pizzas")
public class PizzaRestController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PromoRepository promoRepository;

    @GetMapping
    public List<Pizza> index(@RequestParam(name = "keyword", required = false) String name) {

        List<Pizza> result;

        if (name != null && !name.isBlank()) {
            result = pizzaRepository.findByNameContainingIgnoreCase(name);
        } else {
            result = pizzaRepository.findAll();
        }

        return result;
    }
    
    @PostMapping
    public Pizza create(@Valid @RequestBody Pizza pizza) {

        return pizzaRepository.save(pizza);
    }

    @PutMapping("/{id}")
    public Pizza edit(@PathVariable Integer id, @RequestBody Pizza pizza) { 

        return pizzaRepository.save(pizza);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        Pizza pizza = pizzaRepository.findById(id).get();

        for (Promo p : pizza.getPromos()) {
            promoRepository.deleteById(p.getId());
        }
        
        pizzaRepository.deleteById(id);
    }

}
