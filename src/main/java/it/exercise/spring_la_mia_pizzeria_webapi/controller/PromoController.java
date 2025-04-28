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

import it.exercise.spring_la_mia_pizzeria_webapi.model.Promo;
import it.exercise.spring_la_mia_pizzeria_webapi.service.PromoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/promos")
public class PromoController {

    @Autowired
    private PromoService promoService;

    @PostMapping("/create")
    public String store(
            @Valid @ModelAttribute("promo") Promo formPromo,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("editMode", false);
            model.addAttribute("promo", formPromo);

            return "/promos/edit";
        }

        promoService.save(formPromo);

        return "redirect:/pizzas/show/" + formPromo.getPizza().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("promo", promoService.getPromoById(id));
        model.addAttribute("editMode", true);

        return "/promos/edit";
    }

    @PostMapping("/edit/{id}")
    public String doEdit(
            @Valid @ModelAttribute("promo") Promo promo,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("editMode", true);
            model.addAttribute("promo", promo);
            return "/promos/edit";
        }

        promoService.save(promo);
        return "redirect:/pizzas/show/" + promo.getPizza().getId();
    }
}
