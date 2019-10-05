package com.android.airbag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.airbag.R;

public class ReservedBagsAdapter extends RecyclerView.Adapter<ReservedBagsAdapter.ViewHolder> {

    private static final String TAG = "AvailableBagsAdapter";
    private ItemClickListener listener;
    public interface ItemClickListener{
        void onBagItemClickListener(int itemPosition);
    }


    public ReservedBagsAdapter(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reserved_bag_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {

            if (view == itemView) {
                listener.onBagItemClickListener(getAdapterPosition());

            }

        }
    }


}
