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
import org.springframework.web.bind.annotation.RestController;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Promo;
import it.exercise.spring_la_mia_pizzeria_webapi.service.PizzaService;
import it.exercise.spring_la_mia_pizzeria_webapi.service.PromoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/promos")
public class PromoRestController {

    @Autowired
    private PromoService promoService;

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/{id}")
    public Promo create(@PathVariable Integer id, @Valid @RequestBody Promo promo) {
        return promoService.createPromo(id, promo);
    }

    @GetMapping("/{id}")
    public List<Promo> index(@PathVariable Integer id) {
        return pizzaService.findById(id).get().getPromos();
    }

    @PutMapping("/{id}")
    public Promo edit(@PathVariable Integer id, @Valid @RequestBody Promo promo) {
        return promoService.editPromo(id, promo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        promoService.deleteById(id);
    }
}
