package it.exercise.spring_la_mia_pizzeria_webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Pizza;
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

    public Promo createPromo(Integer id, Promo formPromo) {

        Pizza p = pizzaRepo.findById(id).get();
        formPromo.setPizza(p);
        return promoRepo.save(formPromo);
    }

    public Promo save(Promo promo) {

        return promoRepo.save(promo);
    }

    public void deleteById (Integer id) {

        promoRepo.deleteById(id);
    }

    public Promo editPromo(Integer id, Promo formPromo) {

        Promo vecchiaPromo = promoRepo.findById(id).get();

        vecchiaPromo.setTitle(formPromo.getTitle());
        vecchiaPromo.setDateStart(formPromo.getDateStart());
        vecchiaPromo.setDateEnd(formPromo.getDateEnd());
        vecchiaPromo.setDetail(formPromo.getDetail());

        return promoRepo.save(vecchiaPromo);
    }
}
