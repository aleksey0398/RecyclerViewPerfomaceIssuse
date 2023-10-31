package com.example.perfomanceissuse.presentation.vanilla.viewholder

import android.view.ViewGroup.LayoutParams
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView

class LoadingViewHolder(val view: ProgressBar) : RecyclerView.ViewHolder(view) {
    init {
        view.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT,
        )
    }
}
