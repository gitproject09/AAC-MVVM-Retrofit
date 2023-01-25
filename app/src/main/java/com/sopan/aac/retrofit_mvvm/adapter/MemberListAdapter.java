package com.sopan.aac.retrofit_mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sopan.aac.retrofit_mvvm.R;
import com.sopan.aac.retrofit_mvvm.model.Article;
import com.sopan.aac.retrofit_mvvm.model.MemberList;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.ViewHolder> {
    private Context context;
    ArrayList<MemberList> memberLists;

    public MemberListAdapter(Context context, ArrayList<MemberList> memberLists) {
        this.context = context;
        this.memberLists = memberLists;
    }

    @NonNull
    @Override
    public MemberListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_movie_article, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberListAdapter.ViewHolder viewHolder, int i) {
        MemberList memberList = memberLists.get(i);
        viewHolder.tvTitle.setText(memberList.getName() + " | " + "ID: " + memberList.getId());
        viewHolder.tvAuthorAndPublishedAt.setText("Father: " + memberList.getFather() + " | " + "Blood group: " + memberList.getBlood_group());
        viewHolder.tvDescription.setText("Card ID: " + memberList.getCard_id());
        Glide.with(context).load(memberList.getId()).error(R.drawable.amcbd).into(viewHolder.imgViewCover);
    }

    @Override
    public int getItemCount() {
        return memberLists.size();
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
