package com.intern.nudleapp.userAccount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.nudleapp.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {
    private List<CartItemModel> cartitemmodellist;

    public CartAdapter(List<CartItemModel> cartitemmodellist) {
        this.cartitemmodellist = cartitemmodellist;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartitemmodellist.get(position).getType()){
            case 0 :
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType){
            case CartItemModel.CART_ITEM:
                View cartitemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_items_details,viewGroup,false);
                return new CartItemViewHolder(cartitemview);


                case CartItemModel.TOTAL_AMT:
                    View carttotalview =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                    return new CartItemViewHolder(carttotalview);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartitemmodellist.get(position).getType()){
            case CartItemModel.CART_ITEM:
                int resource = cartitemmodellist.get(position).getProductImage();
                String title = cartitemmodellist.get(position).getProductTitle();
                int freecoupons  = cartitemmodellist.get(position).getFreecoupons();
                String ProductPrice = cartitemmodellist.get(position).getProductprice();
                String cuttedprice = cartitemmodellist.get(position).getCuttedprice();
                int offersapplied =  cartitemmodellist.get(position).getOffersapplied();

                ((CartItemViewHolder)holder).SetItemDetails(resource,title,freecoupons,ProductPrice,cuttedprice,offersapplied);
                break;
            case CartItemModel.TOTAL_AMT:
                String totalitems = cartitemmodellist.get(position).getTotalitems();
                String totalitemsprice = cartitemmodellist.get(position).getTotalItemPrice();
                String deliveryprice = cartitemmodellist.get(position).getDeliveryprice();
                String totalamount = cartitemmodellist.get(position).getTotalamount();
                String savedamount = cartitemmodellist.get(position).getSavedamount();
                ((carttotalamountviewholder)holder).SetTotalAmount(totalitems,totalitemsprice,deliveryprice,totalamount,savedamount);


                break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {

        return cartitemmodellist.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView productimage,freecoupon;
        private TextView producttitle,freecoupons,productprice,cuttoffprice,offersapplied,couponsapplied,productquantity;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productimage=itemView.findViewById(R.id.PRODUCT_IMAGE);
            freecoupon =itemView.findViewById(R.id.free_coupon_icon);
            producttitle = itemView.findViewById(R.id.textView3);
            freecoupons=itemView.findViewById(R.id.free_coupons_textview);
            productprice=itemView.findViewById(R.id.product_price);
            cuttoffprice=itemView.findViewById(R.id.cutoff_price);
            offersapplied=itemView.findViewById(R.id.offers_applied);
            couponsapplied=itemView.findViewById(R.id.coupon_applied);
            productquantity=itemView.findViewById(R.id.product_qty);

        }
        private void SetItemDetails(int resource,String title,int freecouponsNo,String productpricetext,String cuttedpricetext, int offersappliedNo){
            productimage.setImageResource(resource);
            producttitle.setText(title);
            if(freecouponsNo>0){
                freecoupons.setVisibility(View.VISIBLE);
                freecoupon.setVisibility(View.VISIBLE);
                if(freecouponsNo==1) {
                    freecoupons.setText("free" + freecouponsNo + "coupon");
                }
                else
                    freecoupons.setText("free" + freecouponsNo + "coupons");
            }
            else{
                freecoupons.setVisibility(View.INVISIBLE);
                freecoupon.setVisibility(View.INVISIBLE);


            }
            productprice.setText(productpricetext);
            cuttoffprice.setText(cuttedpricetext);
            if(offersappliedNo>0){
                offersapplied.setVisibility(View.VISIBLE);
                offersapplied.setText(offersappliedNo+"offers applied");
            }
            else{
                offersapplied.setVisibility(View.INVISIBLE);
            }





        }
    }
    class  carttotalamountviewholder extends RecyclerView.ViewHolder {
        private TextView totalitems,totalprice,deliveryprice,totalamount,savedamount;



        public carttotalamountviewholder(@NonNull View itemView) {
            super(itemView);
            totalitems = itemView.findViewById(R.id.total_items_prices);
            totalprice = itemView.findViewById(R.id.total_items_price);
            deliveryprice = itemView.findViewById(R.id.delivery_charge);
            totalamount = itemView.findViewById(R.id.total_price);
            savedamount = itemView.findViewById(R.id.saved_amount);
        }
        private void SetTotalAmount(String totalitemtext,String totalitempricetext,String deliverypricetext, String totalamounttext,String savedamttext){
            totalitems.setText(totalitemtext);
            totalprice.setText(totalitempricetext);
            deliveryprice.setText(deliverypricetext);
            totalamount.setText(totalamounttext);
            savedamount.setText(savedamttext);
        }



    }
}
