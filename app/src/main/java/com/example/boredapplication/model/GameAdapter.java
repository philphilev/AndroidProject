package com.example.boredapplication.model;

import com.bumptech.glide.Glide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.boredapplication.R;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<GameObject> gameAList;
    final private OnListItemClickListener onListItemClickListener;

    public GameAdapter(List<GameObject> games, OnListItemClickListener onListItemClickListener)
    {
        gameAList = games;
        this.onListItemClickListener = onListItemClickListener;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.game_item_layout, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(gameAList.get(position).getName());
        Glide.with(viewHolder.itemView).load(gameAList.get(position).getPrice())
                .placeholder(R.drawable.logo).error(R.drawable.logo).into(viewHolder.icon);
    }

    public int getItemCount() {
        return gameAList.size();
    }

    public void updateData(List<GameObject> popGames) {
        gameAList = popGames;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.g_name);
            icon = itemView.findViewById(R.id.g_logo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

}

