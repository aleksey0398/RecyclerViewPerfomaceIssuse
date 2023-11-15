package com.example.perfomanceissuse.presentation.vanilla.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.perfomanceissuse.databinding.ItemProductBinding
import com.example.perfomanceissuse.presentation.recycli.product.ProductItem

class ProductViewHolder(
    private val binding: ItemProductBinding,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        Log.i(TAG, "Product [init]")
    }

    fun bind(state: ProductItem.State) {
        Log.i(TAG, "Product [bind](${state.name})")
        binding.textViewProductName.text = state.name
        binding.textViewPriceNew.text = state.priceNew
        binding.textViewPriceOld.text = state.priceOld
        binding.imageView.load(state.imageUrl)
    }

    private companion object {
        const val TAG = "Product"
    }
}
