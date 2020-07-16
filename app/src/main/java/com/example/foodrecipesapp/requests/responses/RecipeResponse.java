package com.example.foodrecipesapp.requests.responses;

import androidx.annotation.Nullable;

import com.example.foodrecipesapp.models.Recipe;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RecipeResponse {
   @SerializedName("recipe")
   @Expose
    private Recipe recipe;

    @SerializedName("error")
    @Expose
    private String error;

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "recipes=" + recipe +
                ", error='" + error + '\'' +
                '}';
    }

    @Nullable
    public Recipe getRecipes() {
        return recipe;
    }

    public String getError() {
        return error;
    }
}
