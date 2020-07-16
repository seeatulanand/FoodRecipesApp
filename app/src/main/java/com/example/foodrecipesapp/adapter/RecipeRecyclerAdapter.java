package com.example.foodrecipesapp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.example.foodrecipesapp.R;
import com.example.foodrecipesapp.models.Recipe;
import com.example.foodrecipesapp.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>implements ListPreloader.PreloadModelProvider<String> {
    private static final int RECIPE_TYPE = 1;
    private static final int CATEGORY_TYPE = 3;

    private OnRecipeListener mOnRecipeListener;
    private RequestManager requestManager;
    private ViewPreloadSizeProvider<String> preloadSizeProvider;

    private List<Recipe> mRecipes;

    public RecipeRecyclerAdapter(OnRecipeListener mOnRecipeListener,
                                 RequestManager requestManager,
                                 ViewPreloadSizeProvider<String> preloadSizeProvider) {
        this.mOnRecipeListener = mOnRecipeListener;
        this.requestManager = requestManager;
        this.preloadSizeProvider = preloadSizeProvider;

    }
    @Override
    public int getItemViewType(int position) {
        if(mRecipes.get(position).getSocial_rank() == -1){
            return CATEGORY_TYPE;
        }
        else{
            return RECIPE_TYPE;
        }
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        switch (i) {

            case CATEGORY_TYPE:
            {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_category_list_item, viewGroup, false);
                return new CategoryViewHolder(view, mOnRecipeListener, requestManager);
            }
            default:{
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recipe_list_item, viewGroup, false);
                return new RecipeViewHolder(view, mOnRecipeListener, requestManager, preloadSizeProvider);
            }
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if(itemViewType == RECIPE_TYPE){
            ((RecipeViewHolder)viewHolder).onBind(mRecipes.get(i));
        }
        else if(itemViewType == CATEGORY_TYPE){
            ((CategoryViewHolder)viewHolder).onBind(mRecipes.get(i));
        }


    }

    @Override
    public int getItemCount() {
        if(mRecipes != null){
            return mRecipes.size();
        }
        return 0;
    }


    public void displaySearchCategories(){
        List<Recipe> categories = new ArrayList<>();
        for(int i = 0; i< Constants.DEFAULT_SEARCH_CATEGORIES.length; i++){
            Recipe recipe = new Recipe();
            recipe.setTitle(Constants.DEFAULT_SEARCH_CATEGORIES[i]);
            recipe.setImage_url(Constants.DEFAULT_SEARCH_CATEGORY_IMAGES[i]);
            recipe.setSocial_rank(-1);
            categories.add(recipe);
        }
        mRecipes = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public List<String> getPreloadItems(int position) {
        String url = mRecipes.get(position).getImage_url();
        if(TextUtils.isEmpty(url)){
            return Collections.emptyList();
        }
        return Collections.singletonList(url);
    }

    @Nullable
    @Override
    public RequestBuilder<?> getPreloadRequestBuilder(@NonNull String item) {
        return requestManager.load(item);
    }
}
