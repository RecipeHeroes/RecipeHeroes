package com.example.recipes;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler;

import okhttp3.Headers;

public class create_recipe extends AppCompatActivity {

    private int count;
    private String name;
    private String author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_recipe);
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
    public create_recipe saveRecipe(String name, String author){
        this.author = author;
        this.name = name;


        return this;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getName(){
        return this.name;
    }


}
