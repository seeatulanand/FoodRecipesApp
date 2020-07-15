package com.example.foodrecipesapp;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;


public class RecipeListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

    }
}
