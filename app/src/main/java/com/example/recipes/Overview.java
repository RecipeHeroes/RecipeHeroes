package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipes.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Overview extends AppCompatActivity {

    private List<String> mSampleQuoteList;
    private List<create_recipe> mQuoteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String logTag = Overview.class.getSimpleName();

        Log.v(logTag, "Verbose     - Meldung.");
        Log.d(logTag, "Debug       - Meldung.");
        Log.i(logTag, "Information - Meldung.");
        Log.w(logTag, "Warning     - Meldung.");
        Log.e(logTag, "Error       - Meldung.");

        Button btn_login = (Button)findViewById(R.id.login_button);
//        Button btn_settings = (Button)findViewById(R.id.settings_button);
        TabLayout btn_settings = (TabLayout) findViewById(R.id.tabs);
        Button btn_recipelist = (Button)findViewById(R.id.recipelist_button);
        Button btn_test = (Button)findViewById(R.id.Testbutton);

 /*       btn_recipelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, RecipeList.class));
            }
        });*/

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, LoginActivity.class));
            }
        });

          btn_settings.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
              @Override
                 public void onTabSelected(TabLayout.Tab tab) {
                        switch(tab.getPosition()) {
                            case 1:
                                startActivity(new Intent(Overview.this, RecipeList.class));
                                break;
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
//        btn_settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Overview.this, SettingsActivity.class));
//            }
//        });

        Button btn_register = (Button)findViewById(R.id.register_button);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, RegisterActivity.class));
            }
        });

        //Create Recipe
        FloatingActionButton btn_createRecipe = (FloatingActionButton) findViewById(R.id.floating_add_button);
        btn_createRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, create_recipe.class));
            }
        });
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipe = new Intent(Overview.this, show_one_recipe2.class);
                    recipe.putExtra("id", "00000001-0000-0000-0000-000000000002");
                startActivity(recipe);
            }
        });
    }

}