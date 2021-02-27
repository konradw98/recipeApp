package com.konrad.recipe.controllers;

import com.konrad.recipe.domain.Recipe;
import com.konrad.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService=recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe",recipeService.findById((Long.valueOf(id))));

        return "recipe/show";
    }
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        Recipe r1=recipeService.findById(1L);
        model.addAttribute("recipe",r1);
         return "recipe/recipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute Recipe recipe){
        recipeService.saveRecipe(recipe);

        return "redirect:/recipe/show/"+recipe.getId();
    }
}
