package com.intern.nudleapp.rewards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.nudleapp.R;

import java.util.ArrayList;

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.RewardViewHolder> {

    ArrayList<Reward> rewards;

    public static class RewardViewHolder extends RecyclerView.ViewHolder {

        public TextView status;
        public TextView nudle_cash;

        public RewardViewHolder(@NonNull View itemView) {
            super(itemView);

            status = itemView.findViewById(R.id.text_status);
            nudle_cash = itemView.findViewById(R.id.text_nudle_cash);
        }
    }

    public RewardAdapter(ArrayList<Reward> rewards) {
        this.rewards = rewards;
    }

    @NonNull
    @Override
    public RewardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_rewards, parent, false);
        return new RewardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardViewHolder holder, int position) {
        Reward reward = rewards.get(position);
        holder.status.setText(reward.getStatus());
        holder.nudle_cash.setText(reward.getNudle_cash());
    }

    @Override
    public int getItemCount() {
        return rewards.size();
    }
}
