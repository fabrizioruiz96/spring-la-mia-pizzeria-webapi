package it.exercise.spring_la_mia_pizzeria_webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.exercise.spring_la_mia_pizzeria_webapi.model.Ingredient;
import it.exercise.spring_la_mia_pizzeria_webapi.service.IngredientService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping()
    public String index(Model model) {

        model.addAttribute("list", ingredientService.findIngredientList());
        model.addAttribute("ingredientObj", new Ingredient());

        return "/ingredients/index";
    }

    @PostMapping("/create")
    public String store(
        @Valid @ModelAttribute("ingredientObj") Ingredient ingredient,
        BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            ingredientService.save(ingredient);
        }

        return "redirect:/ingredients";
    }

    @PostMapping("/delete/{id}") 
    public String delete(@PathVariable("id") Integer id, Model model) {
        ingredientService.delete(id);
        return "redirect:/ingredients";
    }

}
