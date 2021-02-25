package com.konrad.recipe.controllers;

import com.konrad.recipe.domain.Category;
import com.konrad.recipe.domain.Recipe;
import com.konrad.recipe.domain.UnitOfMeasure;
import com.konrad.recipe.repositories.CategoryRepository;
import com.konrad.recipe.repositories.RecipeRepository;
import com.konrad.recipe.repositories.UnitOfMeasureRepository;
import com.konrad.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;
    private final RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,RecipeRepository recipeRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository=recipeRepository;
        this.recipeService=recipeService;
    }

    @RequestMapping({"/index","","/"})
    public String getIndexPage(Model model){

       /* Optional<Category> categoryOptional=categoryRepository.findByCategoryName("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional=unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id is:"+categoryOptional.get().getId());
        System.out.println("UOM id is:"+unitOfMeasureOptional.get().getId());*/

        Set<Recipe> recipes= recipeService.getRecipes();
        model.addAttribute("recipes",recipes);

        return "index";
    }
}
