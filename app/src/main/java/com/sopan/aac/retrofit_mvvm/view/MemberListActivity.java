package com.sopan.aac.retrofit_mvvm.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.sopan.aac.retrofit_mvvm.R;
import com.sopan.aac.retrofit_mvvm.adapter.MemberListAdapter;
import com.sopan.aac.retrofit_mvvm.model.MemberList;
import com.sopan.aac.retrofit_mvvm.view_model.MemberListViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MemberListActivity extends AppCompatActivity {

    private static final String TAG = MemberListActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager layoutManager;
    private MemberListAdapter adapter;
    private ArrayList<MemberList> memberLists = new ArrayList<>();
    MemberListViewModel memberListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_member_list);

        initialization();

        getRegisterMemberList();
    }

    /**
     * initialization of views and others
     *
     * @param @null
     */
    private void initialization() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.rvMemberList);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(MemberListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // adapter
        adapter = new MemberListAdapter(MemberListActivity.this, memberLists);
        recyclerView.setAdapter(adapter);

        // View Model
        memberListViewModel = new ViewModelProvider(this).get(MemberListViewModel.class);
        memberListViewModel.makeApiCall("01716253216");

        Log.d("MemberListViewModel", "Call Finish");
      //  memberListViewModel = new ViewModelProvider(this, new MemberListViewModel(this.getApplication(), "01716253216")).get(MemberListViewModel.class);

    }

    /**
     * get movies articles from news api
     *
     * @param @null
     */
    private void getRegisterMemberList() {
        memberListViewModel.getMemberListResponseLiveData().observe(this, memberListResponse -> {
            if (memberListResponse != null) {
                progressBar.setVisibility(View.GONE);
                List<MemberList> memLists = memberListResponse.getMemberLists();
                this.memberLists.addAll(memLists);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
