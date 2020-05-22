package com.intern.nudleapp.Cart_Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.nudleapp.R;

import java.util.List;

public class TotalItemAdapter extends RecyclerView.Adapter<TotalItemAdapter.TotalViewHolder> {

    private List<TotalModel> totalModelList;
    public TotalItemAdapter(List<TotalModel> totalModelList) {

        this.totalModelList = totalModelList;
    }

    @NonNull
    @Override
    public TotalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View carttotalview =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                    return new TotalViewHolder(carttotalview);
    }

    @Override
    public void onBindViewHolder(@NonNull TotalItemAdapter.TotalViewHolder holder, int position) {
        TotalModel t = totalModelList.get(0);
        holder.deliveryprice.setText(t.getDeliveryprice());
        holder.savedamount.setText(t.getSavedamount());
        holder.totalamount.setText(t.getTotalamount());
        holder.totalprice.setText(t.getTotalItemPrice());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TotalViewHolder extends RecyclerView.ViewHolder{
        private TextView otalitems,totalprice,deliveryprice,totalamount,savedamount;


        public TotalViewHolder(@NonNull View itemView) {
            super(itemView);
            totalprice = itemView.findViewById(R.id.total_items_price);
            deliveryprice = itemView.findViewById(R.id.delivery_charge);
            totalamount = itemView.findViewById(R.id.total_amount);
            savedamount = itemView.findViewById(R.id.saved_amount);
        }
    }
}
