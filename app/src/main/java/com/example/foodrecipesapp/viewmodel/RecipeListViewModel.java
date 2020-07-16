package com.example.foodrecipesapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RecipeListViewModel extends AndroidViewModel {
    public enum ViewState {CATEGORIES, RECIPES}

    private MutableLiveData<ViewState> viewState;

    public RecipeListViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init() {
        if(viewState==null)
        {
            viewState = new MutableLiveData<ViewState>();
            viewState.setValue(ViewState.CATEGORIES);
        }
    }
    public LiveData<ViewState> getViewstate(){
        return viewState;
    }
}
