package com.example.perfomanceissuse.presentation.recycli.category

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.os.trace
import androidx.recyclerview.widget.LinearLayoutManager
import com.detmir.recycli.adapters.RecyclerAdapter
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.databinding.ItemCategoryRecycliBinding
import com.example.perfomanceissuse.presentation.decoration.ProductDecoration

@RecyclerItemView
class CategoryItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0,
) : LinearLayout(context, attrs, defStyleAttrs), CategoryItem.View {

    private val binding = ItemCategoryRecycliBinding.inflate(LayoutInflater.from(context), this)
    private val adapter = RecyclerAdapter()

    init {
        trace("Category item init") {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
            elevation = 10f
            setBackgroundResource(android.R.color.white)
            orientation = VERTICAL

            binding.recyclerProducts.apply {
                clipChildren = false
                this.adapter = this@CategoryItemView.adapter
                addItemDecoration(ProductDecoration())

                layoutManager = LinearLayoutManager(context).apply {
                    orientation = LinearLayoutManager.HORIZONTAL
                }
            }
        }
    }

    @RecyclerItemStateBinder
    override fun bindState(state: CategoryItem.State) {
        binding.title.text = state.title
        adapter.bindState(state.products)
    }

}
