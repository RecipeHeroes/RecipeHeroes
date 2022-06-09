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

        RecyclerView recyclerView = findViewById(R.id.recipe_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://10.0.2.2:4004/recipe-heroes/Recipe";
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                try {
                    ArrayList<RecipeListItem> testValues = new ArrayList<RecipeListItem>();

                    JSONArray jsonArray = json.jsonObject.getJSONArray("value");
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject((i));
                        testValues.add(new RecipeListItem(
                                jsonObject.getString("ID"),
                                jsonObject.getString("Title"),
                                "2022-06-07")
                        );
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

