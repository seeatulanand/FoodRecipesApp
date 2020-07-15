package com.example.foodrecipesapp.requests.responses;

import androidx.annotation.Nullable;

import com.example.foodrecipesapp.models.Recipes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeSearchResponse {

    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("error")
    @Expose
    private String error;


    @SerializedName("recipes")
    @Expose
    private List<Recipes> recipes;

    public String getCount() {
        return count;
    }

    public String getError() {
        return error;
    }
    @Nullable
    public List<Recipes> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return "RecipeSearchResponse{" +
                "count='" + count + '\'' +
                ", error='" + error + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
