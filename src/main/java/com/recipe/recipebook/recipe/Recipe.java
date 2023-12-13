package com.recipe.recipebook.recipe;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.recipe.recipebook.ingredient.Ingredient;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Recipe")
@Table(
        name = "recipe"
)
public class Recipe {
    @Id
    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long recipeId;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            name = "instructions",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String instructions;

    @OneToMany(
            mappedBy = "recipe",
            orphanRemoval = true,
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE }
    )
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();



}
