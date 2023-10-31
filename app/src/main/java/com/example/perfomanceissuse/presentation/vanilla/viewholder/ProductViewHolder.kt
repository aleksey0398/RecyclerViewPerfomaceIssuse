package com.example.perfomanceissuse.presentation.vanilla.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.perfomanceissuse.databinding.ItemProductBinding
import com.example.perfomanceissuse.presentation.recycli.product.ProductItem

class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(state: ProductItem.State) = with(binding) {
        binding.textViewProductName.text = state.name
        binding.textViewPriceNew.text = state.priceNew
        binding.textViewPriceOld.text = state.priceOld
        binding.imageView.load(state.imageUrl)
    }
}