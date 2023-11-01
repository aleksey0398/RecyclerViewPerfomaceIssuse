package com.example.perfomanceissuse.presentation.recycli.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.R
import com.example.perfomanceissuse.databinding.ItemButtonBinding

@RecyclerItemView
class ButtonItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defAttrs), ButtonItem.View {

    private val binding = ItemButtonBinding.inflate(LayoutInflater.from(context), this)

    init {
        layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
        )
        setOnClickListener {
            Log.d("Button", "On button click")
        }
        if (isInEditMode) {
            binding.text.text = "this is text"
        }
        setBackgroundResource(R.drawable.button_background)
    }

    @RecyclerItemStateBinder
    override fun bindState(state: ButtonItem.State) {
        binding.image.setBackgroundResource(state.iconRes)
        binding.text.text = state.text
    }
}
