package com.example.perfomanceissuse.presentation.recycli.ui

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState
import com.example.perfomanceissuse.R

class ButtonItem {

    interface View {
        fun bindState(state: State)
    }

    @RecyclerItemState
    data class State(
        val id: String,
        val text: String,
        @DrawableRes val iconRes: Int = R.drawable.baseline_headset_24
    ) : RecyclerItem {
        override fun provideId(): String {
            return id
        }
    }
}
