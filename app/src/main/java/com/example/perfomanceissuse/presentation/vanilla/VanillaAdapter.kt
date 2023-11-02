package com.example.perfomanceissuse.presentation.vanilla

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.detmir.recycli.adapters.RecyclerItem
import com.example.perfomanceissuse.databinding.ItemCategoryBinding
import com.example.perfomanceissuse.databinding.ItemProductBinding
import com.example.perfomanceissuse.presentation.recycli.category.CategoryItem
import com.example.perfomanceissuse.presentation.recycli.loading.LoadingItem
import com.example.perfomanceissuse.presentation.recycli.product.ProductItem
import com.example.perfomanceissuse.presentation.vanilla.viewholder.CategoryViewHolder
import com.example.perfomanceissuse.presentation.vanilla.viewholder.LoadingViewHolder
import com.example.perfomanceissuse.presentation.vanilla.viewholder.ProductViewHolder

class VanillaAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var items: List<RecyclerItem> = emptyList()
    private val diffUtil = VanillaDiffUtil()

    private val sharedViewPool = RecyclerView.RecycledViewPool()

    fun submitList(items: List<RecyclerItem>) {
        diffUtil.newList = items
        diffUtil.oldList = this.items
        DiffUtil.calculateDiff(diffUtil).dispatchUpdatesTo(this)
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            VIEW_TYPE_PRODUCT -> {
                val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ProductViewHolder(binding)
            }

            VIEW_TYPE_CATEGORY -> {
                val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.recyclerProducts.setRecycledViewPool(sharedViewPool)
                CategoryViewHolder(binding)
            }

            VIEW_TYPE_LOADING -> {
                LoadingViewHolder(ProgressBar(parent.context))
            }

            else -> throw Exception("unknown view type")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        when {
            holder is CategoryViewHolder && item is CategoryItem.State -> holder.bind(item)
            holder is ProductViewHolder && item is ProductItem.State -> holder.bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is CategoryItem.State -> VIEW_TYPE_CATEGORY
            is ProductItem.State -> VIEW_TYPE_PRODUCT
            is LoadingItem.State -> VIEW_TYPE_LOADING
            else -> throw Exception("Unknown type")
        }
    }

    class VanillaDiffUtil(
        var oldList: List<RecyclerItem> = emptyList(),
        var newList: List<RecyclerItem> = emptyList(),
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].provideId() == newList[newItemPosition].provideId()
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

    private companion object {
        const val VIEW_TYPE_PRODUCT = 0
        const val VIEW_TYPE_CATEGORY = 1
        const val VIEW_TYPE_LOADING = 2
        const val TAG = "MyAdapter"
    }
}
