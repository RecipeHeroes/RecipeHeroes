package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipes.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Overview extends AppCompatActivity {

    private List<String> mSampleQuoteList;
    private List<create_recipe> mQuoteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set activity_main screen
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String logTag = Overview.class.getSimpleName();

        Log.v(logTag, "Verbose     - Meldung.");
        Log.d(logTag, "Debug       - Meldung.");
        Log.i(logTag, "Information - Meldung.");
        Log.w(logTag, "Warning     - Meldung.");
        Log.e(logTag, "Error       - Meldung.");

        //get buttons and Tablayout
        Button btn_login = (Button)findViewById(R.id.login_button);
        TabLayout tab_overview = (TabLayout) findViewById(R.id.tabs);
        Button btn_register = (Button)findViewById(R.id.register_button);
        FloatingActionButton btn_createRecipe = (FloatingActionButton) findViewById(R.id.floating_add_button);

        // Call Login Class
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, LoginActivity.class));
            }
        });

        // Call Register Class
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, RegisterActivity.class));
            }
        });

        // Call Create Recipe Class
        btn_createRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, create_recipe.class));
            }
        });

        // set on tab listener when user switches tabs and call the selected Class (settings oder recipe list)
          tab_overview.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
              @Override
                 public void onTabSelected(TabLayout.Tab tab) {
                        switch(tab.getPosition()) {
                            // Show Recipe List
                            case 1:
                                startActivity(new Intent(Overview.this, RecipeList.class));
                                break;
                            // Show Settings
                             case 2:
                                 startActivity(new Intent(Overview.this, SettingsActivity.class));
                                   }
                                }

                                @Override
                               public void onTabUnselected(TabLayout.Tab tab) {

                             }

                              @Override
                         public void onTabReselected(TabLayout.Tab tab) {

                   }
                 }


          );
    }

}