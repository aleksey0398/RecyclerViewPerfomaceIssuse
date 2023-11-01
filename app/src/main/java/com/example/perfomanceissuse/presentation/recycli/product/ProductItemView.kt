package com.example.perfomanceissuse.presentation.recycli.product

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.trace
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.R
import com.example.perfomanceissuse.databinding.ItemProductRecycliBinding

@RecyclerItemView
class ProductItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defAttrs), ProductItem.View {

    private val binding = ItemProductRecycliBinding.inflate(LayoutInflater.from(context), this)

    init {
        trace("ProductItemView init") {
            layoutParams = LayoutParams(
                400,
                LayoutParams.WRAP_CONTENT
            )
            elevation = 10f
            setBackgroundResource(R.drawable.rounded)
            val padding = 20
            setPadding(padding, padding, padding, padding)
        }

    }

    @RecyclerItemStateBinder
    override fun bindState(state: ProductItem.State) {
        binding.textViewProductName.text = state.name
        binding.textViewPriceNew.text = state.priceNew
        binding.textViewPriceOld.text = state.priceOld
//        binding.imageView.load(state.imageUrl)
    }
}
