package com.konrad.recipe.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int prepTime;
    private int cookTime;
    private int servings;
    private String url;
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private Set<Ingredient>  ingredients;

    @ManyToMany
    @JoinTable(name="recipe_category", joinColumns =@JoinColumn(name="recipe_id"),inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories;

    public void setNotes(Notes notes){
        this.notes=notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }



}
