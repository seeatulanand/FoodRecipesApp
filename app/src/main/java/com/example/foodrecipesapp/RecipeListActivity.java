package com.example.foodrecipesapp;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.example.foodrecipesapp.adapter.OnRecipeListener;
import com.example.foodrecipesapp.adapter.RecipeRecyclerAdapter;
import com.example.foodrecipesapp.viewmodel.RecipeListViewModel;


public class RecipeListActivity extends BaseActivity implements OnRecipeListener
{

    private RecyclerView mRecyclerView;
    private SearchView mSearchView;
    private RecipeRecyclerAdapter mAdapter;
    private RecipeListViewModel mRecipeListViewModel;
    @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recipe_list);

            mRecyclerView = findViewById(R.id.recipe_list);
            mSearchView = findViewById(R.id.search_view);
            mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);

            initRecyclerView();
            subscribeCategoriesObserver();

            setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

        }

        private void subscribeCategoriesObserver() {
            mRecipeListViewModel.getViewstate().observe(this, new Observer<RecipeListViewModel.ViewState>() {
                @Override
                public void onChanged(RecipeListViewModel.ViewState viewState) {
                    if(viewState!=null)
                    {
                        switch (viewState)
                        {
                            case RECIPES:
                                break;
                            case CATEGORIES:
                                displaySearchCategories();
                                break;

                        }
                    }
                }
            });


        }

        private void initRecyclerView()
        {
            ViewPreloadSizeProvider<String> viewPreloader = new ViewPreloadSizeProvider<>();
            mAdapter = new RecipeRecyclerAdapter(this, initGlide(), viewPreloader);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            RecyclerViewPreloader<String> preloader = new RecyclerViewPreloader<String>(Glide.with(this),mAdapter, viewPreloader, 30);
            mRecyclerView.addOnScrollListener(preloader);
            mRecyclerView.setAdapter(mAdapter);
        }

        private RequestManager initGlide()
        {

            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.white_background)
                    .error(R.drawable.white_background);

            return Glide.with(this)
                    .setDefaultRequestOptions(options);
        }

        @Override
        public void onRecipeClick(int position)
        {

        }

        @Override
        public void onCategoryClick(String category) { }

     private void displaySearchCategories(){
        mAdapter.displaySearchCategories();
    }

}
