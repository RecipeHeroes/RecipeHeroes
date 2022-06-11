package com.example.recipes.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipes.R;
import com.example.recipes.entity.RecipeListItem;
import com.example.recipes.Show_SingleRecipe;
import com.example.recipes.enums.Difficulty;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private final ArrayList<RecipeListItem> values;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private String recipeID;
        private final TextView titleTextView, authorTextView, difficultyTV, portionsTV, durationTV;
        MyOnClickListener mOnClickListener = new MyOnClickListener();

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            view.setOnClickListener(mOnClickListener);
            titleTextView = (TextView) view.findViewById(R.id.recipeTitle);
            authorTextView = (TextView) view.findViewById(R.id.recipeAuthor);
            difficultyTV = (TextView) view.findViewById(R.id.recipeDifficulty);
            portionsTV = (TextView) view.findViewById(R.id.recipePortions);
            durationTV = (TextView) view.findViewById(R.id.recipeDuration);
        }

        public void setRecipeListItem(RecipeListItem listItem) {
            this.recipeID = listItem.id;
            this.mOnClickListener.setRecipeID((this.recipeID));
            this.titleTextView.setText(listItem.title);
            this.authorTextView.setText(listItem.author);
            this.difficultyTV.setText("Schwierigkeit: "+ Difficulty.get(listItem.difficulty).getLabel());
            this.portionsTV.setText( "Anzahl Personen: "+listItem.portionPersons);
            this.durationTV.setText("Dauer: "+listItem.durationMinutes+" Minuten");
        }

        public String getRecipeID() {
            return this.recipeID;
        }

        public void setRecipeID(String recipeID) {
            this.recipeID = recipeID;
            this.mOnClickListener.setRecipeID(recipeID);
        }

        private static class MyOnClickListener implements View.OnClickListener {
            private String recipeID;

            public void setRecipeID(String recipeID) {
                this.recipeID = recipeID;
            }

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Show_SingleRecipe.class);
                intent.putExtra("id", this.recipeID);
                view.getContext().startActivity(intent);

                //Toast.makeText(view.getContext(), "Hello World", Toast.LENGTH_LONG).show();
            }
        }
    }



    public RecipeAdapter (ArrayList<RecipeListItem> values) {
        this.values = values;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setRecipeListItem(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}

