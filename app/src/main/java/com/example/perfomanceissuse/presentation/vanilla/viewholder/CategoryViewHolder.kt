package com.example.perfomanceissuse.presentation.vanilla.viewholder

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.perfomanceissuse.databinding.ItemCategoryBinding
import com.example.perfomanceissuse.presentation.decoration.ProductDecoration
import com.example.perfomanceissuse.presentation.recycli.category.CategoryItem
import com.example.perfomanceissuse.presentation.vanilla.VanillaAdapter

class CategoryViewHolder(
    private val binding: ItemCategoryBinding,
) : RecyclerView.ViewHolder(binding.root) {

    private val vanillaAdapter = VanillaAdapter()

    init {
        Log.d(TAG, "Category [init]")
        binding.recyclerProducts.apply {
            this.adapter = vanillaAdapter

            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
                recycleChildrenOnDetach = true
                initialPrefetchItemCount = 3
            }

            addItemDecoration(ProductDecoration())
        }
    }

    fun bind(state: CategoryItem.State) {
        Log.d(TAG, "Category [bind](${state.id})")
        binding.title.text = state.title
        vanillaAdapter.submitNestedList(state.products)
    }

    private companion object {
        const val TAG = "Category"
    }
}
