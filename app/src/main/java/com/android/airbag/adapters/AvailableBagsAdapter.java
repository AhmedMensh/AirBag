package com.android.airbag.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.airbag.R;

public class AvailableBagsAdapter extends RecyclerView.Adapter<AvailableBagsAdapter.ViewHolder> {

    private static final String TAG = "AvailableBagsAdapter";
    private ItemClickListener listener;

    public interface ItemClickListener {
        void onItemClickListener(int itemPosition);
    }


    public AvailableBagsAdapter(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bag_item,parent, false);
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
        LinearLayout moreDetailsLayout,bagInfoLayout;
        Button addNewItemBtn;
        ConstraintLayout itemInfoCL;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moreDetailsLayout = itemView.findViewById(R.id.more_details_layout);
            addNewItemBtn = itemView.findViewById(R.id.add_item_btn);
            itemInfoCL = itemView.findViewById(R.id.item_info_layout);
            bagInfoLayout = itemView.findViewById(R.id.bag_info_layout);
            itemView.setOnClickListener(this);
            moreDetailsLayout.setOnClickListener(this);
            addNewItemBtn.setOnClickListener(this);
            bagInfoLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.add_item_btn:
                    expand(itemInfoCL);
                    addNewItemBtn.setVisibility(View.GONE);
                    break;

                case R.id.bag_info_layout:
                    if (moreDetailsLayout.getVisibility() == View.GONE) {
                        expand(moreDetailsLayout);
                        addNewItemBtn.setVisibility(View.VISIBLE);

//                    listener.onBagItemClickListener(getAdapterPosition());
                    } else {
                        collapse(moreDetailsLayout);
                        addNewItemBtn.setVisibility(View.GONE);
                        itemInfoCL.setVisibility(View.GONE);

                    }

            }


        }

    }


    public static void expand(final View v) {
        int matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(((View) v.getParent()).getWidth(), View.MeasureSpec.EXACTLY);
        int wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        v.measure(matchParentMeasureSpec, wrapContentMeasureSpec);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // Expansion speed of 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // Collapse speed of 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }
}
