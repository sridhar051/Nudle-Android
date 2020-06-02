package com.intern.nudleapp.rewards;

import android.graphics.Color;
import android.graphics.Paint;
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

        public TextView status, nudle_cash, terms_and_conditions;
        public View strike_view;

        public RewardViewHolder(@NonNull View itemView) {
            super(itemView);

            status = itemView.findViewById(R.id.text_status);
            nudle_cash = itemView.findViewById(R.id.text_nudle_cash);
            terms_and_conditions = itemView.findViewById(R.id.terms);
            strike_view = itemView.findViewById(R.id.strike);
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
        holder.terms_and_conditions
                .setPaintFlags(holder.terms_and_conditions.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        if (reward.getStatus().equalsIgnoreCase("expired")) {
            holder.status.setTextColor(Color.parseColor("#FA0101"));
            holder.strike_view.setBackgroundColor(Color.parseColor("#FA0101"));
        } else
            holder.status.setTextColor(Color.parseColor("#11A10C"));
    }

    @Override
    public int getItemCount() {
        return rewards.size();
    }
}
