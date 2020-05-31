package com.intern.nudleapp.rewards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.nudleapp.R;
import com.intern.nudleapp.rewards.Reward;

import java.util.ArrayList;

public class RewardsFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RewardAdapter mAdapter;

    public RewardsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        ArrayList<Reward> rewards = new ArrayList<>();
        rewards.add(new Reward("Expired", "10 Nudle Cash"));
        rewards.add(new Reward("Expires on 30th June, 2020", "20 Nudle Cash"));
        rewards.add(new Reward("Expires in a week", "10 Nudle Cash"));

        mRecyclerView = view.findViewById(R.id.my_rewards_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RewardAdapter(rewards);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
