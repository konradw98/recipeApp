package com.konrad.recipe.services;

import com.konrad.recipe.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    void saveRecipe(Recipe recipe);
}
