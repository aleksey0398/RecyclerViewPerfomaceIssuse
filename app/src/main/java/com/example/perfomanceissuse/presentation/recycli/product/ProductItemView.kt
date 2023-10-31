package com.example.perfomanceissuse.presentation.recycli.product

import android.content.Context
import android.os.Debug
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.R
import com.example.perfomanceissuse.databinding.ItemProductBinding

@RecyclerItemView
class ProductItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defAttrs), ProductItem.View {

    private val binding = ItemProductBinding.inflate(LayoutInflater.from(context), this, true)

    @RecyclerItemStateBinder
    override fun bindState(state: ProductItem.State) {
        binding.textViewProductName.text = state.name
        binding.textViewPriceNew.text = state.priceNew
        binding.textViewPriceOld.text = state.priceOld
        binding.imageView.load(state.imageUrl)
    }
}
