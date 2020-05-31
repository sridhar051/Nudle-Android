package com.intern.nudleapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.intern.nudleapp.rewards.Reward;

import java.util.ArrayList;

public class RewardsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        ArrayList<Reward> rewardList = new ArrayList<>();
        rewardList.add(new Reward("Expired", "10 Nudle Cash"));
        rewardList.add(new Reward("Expires on 30th June, 2020", "20 Nudle Cash"));
        rewardList.add(new Reward("Expires in a week", "10 Nudle Cash"));

        return view;
    }
}
