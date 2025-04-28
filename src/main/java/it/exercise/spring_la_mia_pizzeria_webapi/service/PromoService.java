package it.exercise.spring_la_mia_pizzeria_webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Promo;
import it.exercise.spring_la_mia_pizzeria_webapi.repository.PizzaRepository;
import it.exercise.spring_la_mia_pizzeria_webapi.repository.PromoRepository;

@Service
public class PromoService {

    @Autowired
    private PromoRepository promoRepo;

    @Autowired
    private PizzaRepository pizzaRepo;

    public Promo getPromoById (Integer id) {
        return promoRepo.findById(id).get();
    }

    public Promo save(Promo promo) {
        return promoRepo.save(promo);
    }

    public Promo create(Integer id) {

        Promo promo = new Promo();
        promo.setPizza(pizzaRepo.findById(id).get());

        return promo;
    }

    public void deleteById (Integer id) {
        promoRepo.deleteById(id);
    }
}
