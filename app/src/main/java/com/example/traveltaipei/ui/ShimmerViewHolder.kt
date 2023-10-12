package com.example.traveltaipei.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout

class ShimmerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun startShimmer() {
        if (itemView.rootView != null && itemView.rootView is ShimmerFrameLayout) {
            (itemView.rootView as ShimmerFrameLayout).startShimmer()
        }
    }
}