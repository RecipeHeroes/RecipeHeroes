package com.example.recipes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONException;

import okhttp3.Headers;

public class Show_SingleRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_one_recipe);

        String id = this.getIntent().getExtras().getString("id");
        // get Client
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://10.0.2.2:4004/recipe-heroes/Recipe("+id+")";

        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {

                // Set attributes from json Object
                try {
                    String title = json.jsonObject.getString("Title");
                    String description = json.jsonObject.getString("Description");
                    String difficulty = json.jsonObject.getString("Difficulty");
                    String duration_minutes = json.jsonObject.getString("DurationMinutes");
                    int portions = (int)json.jsonObject.getInt("Portions");

                    Log.d("DEBUG", json.toString());
                // Set View with attributes from json Object
                    TextView title_view = findViewById(R.id.textView);
                    title_view.setText(title);
                    TextView difficulty_view = findViewById(R.id.recipe_difficulty);
                    difficulty_view.setText(difficulty);
                    TextView duration_minutes_view = findViewById(R.id.duration_recipeviewer);
                    duration_minutes_view.setText(duration_minutes);
                    TextView description_view = findViewById(R.id.description_text);
                    description_view.setText(description);
                    Spinner portions_view = findViewById(R.id.portions_recipe);
                    portions_view.setSelection(portions);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, @Nullable Headers headers, String errorResponse, @Nullable Throwable throwable) {
                Log.d("DEBUG", errorResponse);
            }
        });
    }
}