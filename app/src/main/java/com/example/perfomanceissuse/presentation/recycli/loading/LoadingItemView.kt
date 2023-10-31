package com.example.perfomanceissuse.presentation.recycli.loading

import android.content.Context
import android.widget.ProgressBar
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView

@RecyclerItemView
class LoadingItemView(context: Context) : ProgressBar(context), LoadingItem.View {

    @RecyclerItemStateBinder
    override fun bindState(state: LoadingItem.State) {
        //no-op
    }

}
