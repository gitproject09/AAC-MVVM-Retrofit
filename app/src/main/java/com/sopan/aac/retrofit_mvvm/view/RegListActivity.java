package com.sopan.aac.retrofit_mvvm.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.sopan.aac.retrofit_mvvm.R;
import com.sopan.aac.retrofit_mvvm.adapter.RegListAdapter;
import com.sopan.aac.retrofit_mvvm.model.RegList;
import com.sopan.aac.retrofit_mvvm.view_model.RegListViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RegListActivity extends AppCompatActivity {

    private static final String TAG = RegListActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager layoutManager;
    private RegListAdapter adapter;
    private ArrayList<RegList> regLists = new ArrayList<>();
    RegListViewModel regListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reg_list);

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
        layoutManager = new LinearLayoutManager(RegListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // adapter
        adapter = new RegListAdapter(RegListActivity.this, regLists);
        recyclerView.setAdapter(adapter);

        // View Model
        regListViewModel = new ViewModelProvider(this).get(RegListViewModel.class);
        regListViewModel.makeApiCall("01716253216");

        Log.d("MemberListViewModel", "Call Finish");
      //  regListViewModel = new ViewModelProvider(this, new MemberListViewModel(this.getApplication(), "01716253216")).get(MemberListViewModel.class);

    }

    /**
     * get movies articles from news api
     *
     * @param @null
     */
    private void getRegisterMemberList() {
        regListViewModel.getRegListResponseLiveData().observe(this, regListResponse -> {
            if (regListResponse != null) {
                progressBar.setVisibility(View.GONE);
                List<RegList> memLists = regListResponse.getRegLists();
                this.regLists.addAll(memLists);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
