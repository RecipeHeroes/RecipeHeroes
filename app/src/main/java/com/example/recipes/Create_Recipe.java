package com.example.recipes;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestHeaders;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class Create_Recipe extends AppCompatActivity {

    public static Context c;
    private int ID;
    private int Difficulty;
    private int DurationMinutes;
    private int Portions;
    private String Title;
    private String Description;
    private String Author_Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Create_Recipe.c = this;
        super.onCreate(savedInstanceState);
        // set create_recipe Screen
        setContentView(R.layout.create_recipe);

        // get client
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2:4004/recipe-heroes/Recipe", new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, String response) {
                Log.d("DEBUG", response);
            }

            @Override
            public void onFailure(int statusCode, @Nullable Headers headers, String errorResponse, @Nullable Throwable throwable) {
                Log.d("DEBUG", errorResponse);
            }
        });
    }

    public void setRecipeData(){
        this.Title = ((EditText)findViewById(R.id.recipe_name)).getText().toString();
        this.Description = ((EditText)findViewById(R.id.description)).getText().toString();
    }

    public void saveRecipe(View v) throws JSONException {
        // set recipe variables
        this.setRecipeData();
        AsyncHttpClient client = new AsyncHttpClient();
        RequestHeaders requestHeaders = new RequestHeaders();
        RequestParams params = new RequestParams();
        MediaType mt = MediaType.parse("application/json; charset=utf-8");

        // Create JSON to send to backend
        JSONObject jsonObject = new JSONObject()
                .put("Title", this.Title)
                .put("Difficulty", this.Difficulty)
                .put("DurationMinutes", this.DurationMinutes)
                .put("Description", this.Description)
                .put("Portions", this.Portions);

        RequestBody requestBody = RequestBody.create(String.valueOf(jsonObject), mt);

        client.post("http://10.0.2.2:4004/recipe-heroes/Recipe", requestHeaders, params, requestBody, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d("DEBUG", json.toString());
            }

            @Override
            public void onFailure(int statusCode, @Nullable Headers headers, String errorResponse, @Nullable Throwable throwable) {
                Log.d("DEBUG", errorResponse);
            }
        });
    }
}
