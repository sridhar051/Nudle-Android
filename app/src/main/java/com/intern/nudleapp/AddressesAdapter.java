package com.intern.nudleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    private List<AddressesModel> addressesModelList;

    public AddressesAdapter(List<AddressesModel> addressesModelList) {
        this.addressesModelList = addressesModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addresses_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        String name =addressesModelList.get(position).getFullname();
        String address =addressesModelList.get(position).getAddress();
        String pincode =addressesModelList.get(position).getPincode();
        viewholder.setData(name,address,pincode);
    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView fullname;
        private TextView address;
        private TextView pincode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fullname = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            pincode =itemView.findViewById(R.id.pincode);
        }
        private  void setData(String username,String userAddress,String userPincode){
            fullname.setText(username);
            address.setText(userAddress);
            pincode.setText(userPincode);
        }
    }
}
