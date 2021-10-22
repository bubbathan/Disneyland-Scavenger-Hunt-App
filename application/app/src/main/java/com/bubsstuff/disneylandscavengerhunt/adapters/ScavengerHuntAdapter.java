package com.bubsstuff.disneylandscavengerhunt.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.ColumnInfo;

import com.bubsstuff.disneylandscavengerhunt.R;
import com.bubsstuff.disneylandscavengerhunt.models.HuntItem;
import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.util.ResourceBundle;

public class ScavengerHuntAdapter extends RecyclerView.Adapter<ScavengerHuntAdapter.ViewHolder> {
    Context context;
    ObservableArrayList<HuntItem> huntItems;
    OnHuntItemClicked checkItOutListener;
    public interface OnHuntItemClicked {
        public void onClick(HuntItem huntItem);
    }

    public ScavengerHuntAdapter(Context context, ObservableArrayList<HuntItem> huntItems, OnHuntItemClicked checkItOutListener) {
        this.context = context;
        this.huntItems = huntItems;
        this.checkItOutListener = checkItOutListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scavenger_hunt_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HuntItem huntItem = huntItems.get(position);

        ImageView itemImage = holder.itemView.findViewById(R.id.item_image);
        String imageFileName = huntItem.image;
        int photoId = context.getResources().getIdentifier("@drawable/"
                + imageFileName, null, context.getPackageName());
        itemImage.setImageResource(photoId);
        itemImage.setOnClickListener(view -> {
            if (checkItOutListener == null) return;
            checkItOutListener.onClick(huntItem);
        });

        TextView itemText = holder.itemView.findViewById(R.id.hunt_item_name);
        String huntItemName = huntItem.huntItem;
        itemText.setText(huntItemName);

        TextView timesFoundText = holder.itemView.findViewById(R.id.times_found_text);
        int numTimesFound = huntItem.itemFound;
        timesFoundText.setText(Integer.toString(numTimesFound));

    }

    @Override
    public int getItemCount() {
        return huntItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
