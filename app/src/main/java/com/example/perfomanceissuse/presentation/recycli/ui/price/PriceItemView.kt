package com.example.perfomanceissuse.presentation.recycli.ui.price

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.databinding.ItemPriceBinding

@RecyclerItemView
class PriceItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defAttrs), PriceItem.View {

    private val binding = ItemPriceBinding.inflate(LayoutInflater.from(context), this)

    init {
        layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
        )
        if (isInEditMode){
            binding.priceOld.text = "1000"
            binding.priceNew.text = "2000"
        }
    }

    @RecyclerItemStateBinder
    override fun bindState(state: PriceItem.State) {
        binding.priceOld.apply {
            isVisible = state.old != null
            text = state.old
        }
        binding.priceNew.apply {
            val isVisible = state.new != null
            this.isVisible = isVisible
            text = state.new
            binding.view.isVisible = isVisible
        }
    }
}
