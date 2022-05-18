package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipes.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class Overview extends AppCompatActivity {

    private List<String> mSampleQuoteList;
    private List<create_recipe> mQuoteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String logTag = Overview.class.getSimpleName();

        Log.v(logTag, "Verbose     - Meldung.");
        Log.d(logTag, "Debug       - Meldung.");
        Log.i(logTag, "Information - Meldung.");
        Log.w(logTag, "Warning     - Meldung.");
        Log.e(logTag, "Error       - Meldung.");


        Button btn = (Button)findViewById(R.id.button_activity_main);
        Button btn_login = (Button)findViewById(R.id.login_button);
        Button btn_settings = (Button)findViewById(R.id.settings_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, create_recipe.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, LoginActivity.class));
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, SettingsActivity.class));
            }
        });

        Button btn_register = (Button)findViewById(R.id.register_button);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, RegisterActivity.class));
            }
        });

        //Create Recipe
        Button btn_createRecipe = (Button)findViewById(R.id.createRecipe_button);
        btn_createRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, create_recipe.class));
            }
        });
    }

}