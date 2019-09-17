package com.android.airbag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.airbag.R;

public class AvailableBagsAdapter extends RecyclerView.Adapter<AvailableBagsAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bag_item, null);
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
        LinearLayout moreDetailsLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moreDetailsLayout = itemView.findViewById(R.id.more_details_layout);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {

            if (view == itemView) {
                if (moreDetailsLayout.getVisibility() == View.GONE)
                    moreDetailsLayout.setVisibility(View.VISIBLE);
                else
                    moreDetailsLayout.setVisibility(View.GONE);

            }

        }
    }
}
