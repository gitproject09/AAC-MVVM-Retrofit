package com.sopan.aac.retrofit_mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sopan.aac.retrofit_mvvm.R;
import com.sopan.aac.retrofit_mvvm.model.RegList;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RegListAdapter extends RecyclerView.Adapter<RegListAdapter.ViewHolder> {
    private Context context;
    ArrayList<RegList> regLists;

    public RegListAdapter(Context context, ArrayList<RegList> regLists) {
        this.context = context;
        this.regLists = regLists;
    }

    @NonNull
    @Override
    public RegListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_movie_article, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RegListAdapter.ViewHolder viewHolder, int i) {
        RegList regList = regLists.get(i);
        viewHolder.tvTitle.setText(regList.getName() + " | " + "ID: " + regList.getId());
        viewHolder.tvAuthorAndPublishedAt.setText("Father: " + regList.getFather() + " | " + "Blood group: " + regList.getBlood_group());
        viewHolder.tvDescription.setText("Card ID: " + regList.getCard_id());
        Glide.with(context).load(regList.getId()).error(R.drawable.amcbd).into(viewHolder.imgViewCover);
    }

    @Override
    public int getItemCount() {
        return regLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvTitle;
        private final TextView tvAuthorAndPublishedAt;
        private final TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover = (ImageView) itemView.findViewById(R.id.imgViewCover);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthorAndPublishedAt = (TextView) itemView.findViewById(R.id.tvAuthorAndPublishedAt);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
