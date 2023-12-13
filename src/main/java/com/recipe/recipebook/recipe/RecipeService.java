package com.recipe.recipebook.recipe;

import com.recipe.recipebook.ingredient.Ingredient;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RecipeService {

//    @Autowired
    private final RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public Optional<Recipe> getRecipe(Long id) {
        return recipeRepository.findById(id);
    }
//
    public Recipe addRecipe(Recipe recipe) {

        if (recipe.getIngredients().size() > 0) {
            recipe.getIngredients().forEach(ingredient -> {
                ingredient.setRecipe(recipe);
            });
        }

        return recipeRepository.save(recipe);
    }
//
//    public Recipe editRecipe(Long recipeId) {
//
//    }
//
//    public Recipe deleteRecipe(Long recipeId) {
//
//    }
}
