package com.example.perfomanceissuse.presentation.recycli.productgroup

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.R
import com.example.perfomanceissuse.databinding.ItemProductGroupRecycliBinding

@RecyclerItemView
class ProductGroupItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defAttrs), ProductGroupItem.View {

    private val binding = ItemProductGroupRecycliBinding.inflate(LayoutInflater.from(context), this)

    init {
        layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        elevation = 10f
        setBackgroundResource(R.drawable.rounded)
    }

    @RecyclerItemStateBinder
    override fun bindState(state: ProductGroupItem.State) {
        bindProduct(
            binding.textViewProductName,
            binding.textViewPriceOld,
            binding.textViewPriceNew,
            state.products.getOrNull(0)
        )

        bindProduct(
            binding.textViewProductName1,
            binding.textViewPriceOld1,
            binding.textViewPriceNew1,
            state.products.getOrNull(1)
        )

        bindProduct(
            binding.textViewProductName2,
            binding.textViewPriceOld2,
            binding.textViewPriceNew2,
            state.products.getOrNull(2)
        )
    }

    private fun bindProduct(
        name: TextView,
        old: TextView,
        new: TextView,
        state: ProductGroupItem.ProductItemState?,
    ) {
        name.text = state?.name
        new.text = state?.priceNew
        old.text = state?.priceOld
    }
}
