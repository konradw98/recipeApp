package com.konrad.recipe.repositories;

import com.konrad.recipe.domain.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
    @Query(value = "SELECT * FROM recipe",nativeQuery = true)
    List<Recipe> getAll();
}
