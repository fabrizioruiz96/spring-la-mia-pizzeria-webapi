package it.exercise.spring_la_mia_pizzeria_webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Ingredient;
import it.exercise.spring_la_mia_pizzeria_webapi.model.Pizza;
import it.exercise.spring_la_mia_pizzeria_webapi.repository.IngredientRepository;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepo;

    public List<Ingredient> findIngredientList() {
        return ingredientRepo.findAll();
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    public void delete(Integer id) {

        Ingredient ingredient = ingredientRepo.findById(id).get();

        for (Pizza p : ingredient.getPizzas()) {
            p.getIngredients().remove(ingredient);
        }

        ingredientRepo.deleteById(id);
    }

}
