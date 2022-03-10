package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Overview.this, create_recipe.class));
            }
        });
    }

}