package com.example.perfomanceissuse.presentation.vanilla.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.perfomanceissuse.databinding.ItemCategoryBinding
import com.example.perfomanceissuse.presentation.recycli.category.CategoryItem
import com.example.perfomanceissuse.presentation.vanilla.VanillaAdapter

class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    private val vanillaAdapter = VanillaAdapter()

    init {
        binding.root.setBackgroundResource(android.R.color.white)
        binding.root.elevation = 15f

//        binding.recyclerProducts.swapAdapter(adapter, false)
        binding.recyclerProducts.apply {
            this.adapter = vanillaAdapter

            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
//                initialPrefetchItemCount = 5
//                recycleChildrenOnDetach = true
            }
//            setHasFixedSize(true)

            addItemDecoration(
                object : RecyclerView.ItemDecoration() {

                }
            )
        }
    }

    fun bind(state: CategoryItem.State) {
        binding.title.text = state.title
        vanillaAdapter.submitList(state.products)
    }
}
