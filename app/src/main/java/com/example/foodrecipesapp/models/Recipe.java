package com.example.foodrecipesapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Recipe implements Parcelable  {
    private String recipe_id;
    private String title;
    private String publisher;
    private String image_url;
    private float social_rank;
    private String[] ingredients;
    private int timestamp;

    protected Recipe(Parcel in) {
        recipe_id = in.readString();
        title = in.readString();
        publisher = in.readString();
        image_url = in.readString();
        social_rank = in.readFloat();
        ingredients = in.createStringArray();
        timestamp = in.readInt();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public String toString() {
        return "Recipes{" +
                "recipe_id='" + recipe_id + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", image_url='" + image_url + '\'' +
                ", social_rank=" + social_rank +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", timestamp=" + timestamp +
                '}';
    }

    public Recipe() {
    }

    public Recipe(String recipe_id, String title, String publisher, String image_url, float social_rank, String[] ingredients, int timestamp) {
        this.recipe_id = recipe_id;
        this.title = title;
        this.publisher = publisher;
        this.image_url = image_url;
        this.social_rank = social_rank;
        this.ingredients = ingredients;
        this.timestamp = timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(recipe_id);
        parcel.writeString(title);
        parcel.writeString(publisher);
        parcel.writeString(image_url);
        parcel.writeFloat(social_rank);
        parcel.writeStringArray(ingredients);
        parcel.writeInt(timestamp);
    }
}
