package com.example.recipes;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestHeaders;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public class create_recipe extends AppCompatActivity {

    private int count;
    private String name;
    private String author;
    public static Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        create_recipe.c = this;
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

    public void saveRecipe2(View v) throws JSONException {
//        Toast.makeText(create_recipe.c, "Clicked on Button", Toast.LENGTH_LONG).show();
        AsyncHttpClient client = new AsyncHttpClient();
        RequestHeaders requestHeaders = new RequestHeaders();
        RequestParams params = new RequestParams();
        MediaType mt = MediaType.parse("application/json; charset=utf-8");

// Create JSON to send to backend
        JSONObject jsonObject = new JSONObject()
        // To do getter und setter schreiben
                .put("Title", ( (EditText) this.findViewById(R.id.recipe_name)).getText())
                .put("Difficulty", 2)
                .put("DurationMinutes", 20);

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

    public String getAuthor(){
        return this.author;
    }

    public String getName(){
        return this.name;
    }


}
