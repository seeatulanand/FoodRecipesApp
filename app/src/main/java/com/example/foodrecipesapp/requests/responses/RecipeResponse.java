package com.example.foodrecipesapp.requests.responses;

import androidx.annotation.Nullable;

import com.example.foodrecipesapp.models.Recipes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeResponse {
   @SerializedName("recipes")
   @Expose
    private Recipes recipes;

    @SerializedName("recipes")
    @Expose
    private String error;

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "recipes=" + recipes +
                ", error='" + error + '\'' +
                '}';
    }

    @Nullable
    public Recipes getRecipes() {
        return recipes;
    }

    public String getError() {
        return error;
    }
}
