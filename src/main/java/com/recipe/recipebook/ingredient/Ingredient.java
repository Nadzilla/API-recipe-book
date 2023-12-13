package com.recipe.recipebook.ingredient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.recipe.recipebook.recipe.Recipe;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Ingredient")
public class Ingredient {

    public enum QuantityType { CUP, OZ, TEASPOON,  };


    @Id
    @SequenceGenerator(
            name = "ingredient_sequence",
            sequenceName = "ingredient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingredient_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long ingredientId;

    @Column(
            name = "item_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String itemName;

    @Column(
            name = "quantity",
            nullable = false
    )
    private Double quantity;

    @Column(
            name = "quantity_type",
            nullable = false
    )
    private QuantityType quantityType;

    @ManyToOne
    @JoinColumn(
            name = "recipe_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "recipe_ingredient_fk"
            )
    )
    @JsonBackReference
    private Recipe recipe;


}
