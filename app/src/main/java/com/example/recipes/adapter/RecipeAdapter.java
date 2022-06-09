package com.example.recipes.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipes.Overview;
import com.example.recipes.R;
import com.example.recipes.entity.RecipeListItem;
import com.example.recipes.show_onerecipe;
import com.example.recipes.ui.login.LoginActivity;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private final ArrayList<RecipeListItem> values;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final View.OnClickListener mOnClickListener = new RecipeAdapter.MyOnClickListener();

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            view.setOnClickListener(mOnClickListener);
            textView = (TextView) view.findViewById(R.id.examName);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    private static class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            view.getContext().startActivity(new Intent(view.getContext(), show_onerecipe.class));

            Toast.makeText(view.getContext(), "Hello World", Toast.LENGTH_LONG).show();
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
        holder.getTextView().setText(values.get(position).title);

    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}

