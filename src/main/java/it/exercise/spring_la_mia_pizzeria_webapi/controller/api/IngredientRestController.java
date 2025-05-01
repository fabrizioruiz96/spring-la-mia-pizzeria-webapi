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

import it.exercise.spring_la_mia_pizzeria_webapi.model.Ingredient;
import it.exercise.spring_la_mia_pizzeria_webapi.service.IngredientService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/ingredient")
public class IngredientRestController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public Ingredient create(@Valid @RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }

    @GetMapping
    public List<Ingredient> index() {
        return ingredientService.findIngredientList();
    }

    @PutMapping("/{id}")
    public Ingredient edit(@PathVariable Integer id, @Valid @RequestBody Ingredient ingredient) {
        return ingredientService.edit(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        ingredientService.delete(id);
    }
}
