package com.example.recipes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class recipes extends AppCompatActivity {

    private int count;
    private String name;
    private String author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);
    }
    public recipes saveRecipe(String name, String author){
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
