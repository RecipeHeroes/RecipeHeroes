package com.example.recipes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.recipes.adapter.RecipeAdapter;
import com.example.recipes.entity.RecipeListItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class RecipeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        // create Recycler View with recipe items
        RecyclerView recyclerView = findViewById(R.id.recipe_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://10.0.2.2:4004/recipe-heroes/Recipe?$expand=Author";
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                try {
                    ArrayList<RecipeListItem> testValues = new ArrayList<RecipeListItem>();
                    // create ArrayList from json
                    JSONArray jsonArray = json.jsonObject.getJSONArray("value");
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject((i));
                        RecipeListItem listItem = new RecipeListItem();
                        listItem.id = jsonObject.getString("ID");
                        listItem.author = jsonObject.getJSONObject("Author").getString("Username");
                        listItem.date = "2022-06-07";
                        listItem.title = jsonObject.getString("Title");
                        listItem.difficulty = jsonObject.getInt("Difficulty");
                        listItem.durationMinutes = jsonObject.getInt("DurationMinutes");
                        listItem.portionPersons = jsonObject.getInt("Portions");
                        testValues.add(listItem);
                    }

                    RecipeAdapter recipeAdapter = new RecipeAdapter(testValues);

                    recyclerView.setAdapter(recipeAdapter);
                }
                catch (JSONException jsonException){

                }
            }

            @Override
            public void onFailure(int statusCode, @Nullable Headers headers, String errorResponse, @Nullable Throwable throwable) {
                Log.d("DEBUG", errorResponse);
            }
        });

    }


}

