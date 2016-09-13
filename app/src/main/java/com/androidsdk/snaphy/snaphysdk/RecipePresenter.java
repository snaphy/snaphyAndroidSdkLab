package com.androidsdk.snaphy.snaphysdk;

import android.util.Log;

import com.androidsdk.snaphy.snaphyandroidsdk.list.DataList;
import com.androidsdk.snaphy.snaphyandroidsdk.list.Listen;
import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;
import com.androidsdk.snaphy.snaphyandroidsdk.presenter.Presenter;

/**
 * Created by snaphy on 14/9/16.
 */
public class RecipePresenter {
    DataList<Recipe> recipes;
    public RecipePresenter(){

        recipes = new DataList<Recipe>();
        recipes.subscribe(this, new Listen<Recipe>() {
            @Override
            public void onInit(DataList<Recipe> dataList) {
                Log.i("Snaphy", "I am getting initialized");
            }

            @Override
            public void onChange(DataList<Recipe> dataList) {
                Log.i("Snaphy", "I am getting changed" + dataList.size());
            }

            @Override
            public void onClear() {
                Log.i("Snaphy", "I am getting cleared");
            }

            @Override
            public void onRemove(Recipe element, DataList<Recipe> dataList) {
                Log.i("Snaphy", "I am getting removed" + dataList.size());
                Recipe recipe = element;
            }
        });
        Presenter.getInstance();
        Presenter.getInstance().addList("Secret", recipes);
        recipes.add(new Recipe());
        DataList<Recipe> recipeContainer = Presenter.getInstance().getList(Recipe.class, "Secret");
        Recipe recipe = new Recipe();
        recipeContainer.add(recipe);
        recipeContainer.remove(recipe);
        recipeContainer.clear();
    }

    public DataList<Recipe> getRecipes() {
        return recipes;
    }




}
