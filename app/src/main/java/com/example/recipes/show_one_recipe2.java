package com.example.recipes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler;

import org.json.JSONException;

import okhttp3.Headers;

public class show_one_recipe2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_one_recipe2);

        String id = this.getIntent().getExtras().getString("id");

        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://10.0.2.2:4004/recipe-heroes/Recipe("+id+")";
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                try {
                    String title = json.jsonObject.getString("Title");
                    Log.d("DEBUG", json.toString());

                    TextView textView = findViewById(R.id.textView);
                    textView.setText(title);
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