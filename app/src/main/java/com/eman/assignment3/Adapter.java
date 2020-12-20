package com.eman.assignment3;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private String[] caption;
    private  int[] imageIds;

    public Adapter(String[] caption, int[] imageIds) {
        this.caption = caption;
        this.imageIds = imageIds;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView=holder.cardView;
        ImageView imageView=cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(),imageIds[position]);
        imageView.setImageDrawable(dr);
        TextView txt = cardView.findViewById(R.id.text);
        txt.setText(caption[position]);
        cardView.setOnClickListener(v -> {});

    }
    @Override
    public int getItemCount() {
        return caption.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(@NonNull CardView cardView) {
            super(cardView);
            this.cardView= cardView;
        }
    }
}
