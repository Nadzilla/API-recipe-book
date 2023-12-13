package com.recipe.recipebook.recipe;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/user/{userId}/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @CrossOrigin
    @GetMapping
    public List<Recipe> getRecipes() {
        return recipeService.getAllRecipes();
    }

    @CrossOrigin
    @GetMapping(path = "{recipeId}")
    public Optional<Recipe> getRecipeById(@PathVariable("recipeId") Long id) {
        return recipeService.getRecipe(id);
    }

    @CrossOrigin
    @PostMapping
    public void saveRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @CrossOrigin
    @PutMapping(path = "{recipeId}")
    public void updateRecipe(@RequestBody Recipe recipe) {
        //  Update the Recipe in the DB
    }

    @CrossOrigin
    @DeleteMapping(path = "{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long id) {
        //  Delete the Recipe from the DB
    }
}

