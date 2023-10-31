package com.example.perfomanceissuse.presentation.recycli.category

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.detmir.recycli.adapters.RecyclerAdapter
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.databinding.ItemCategoryBinding
import com.example.perfomanceissuse.presentation.decoration.CategoryDecoration

@RecyclerItemView
class CategoryItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttrs), CategoryItem.View {

    private val binding = ItemCategoryBinding.inflate(LayoutInflater.from(context), this, true)
    private val adapter = RecyclerAdapter()

    init {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        binding.recyclerProducts.apply {
            adapter = adapter
            addItemDecoration(CategoryDecoration())

            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }
    }

    @RecyclerItemStateBinder
    override fun bindState(state: CategoryItem.State) {
        binding.title.text = state.title
        adapter.bindState(state.products)
    }

}
