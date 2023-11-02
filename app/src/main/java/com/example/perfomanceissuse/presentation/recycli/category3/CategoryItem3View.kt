package com.example.perfomanceissuse.presentation.recycli.category3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.detmir.recycli.adapters.RecyclerAdapter
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.R
import com.example.perfomanceissuse.databinding.ItemCategory3RecycliBinding
import com.example.perfomanceissuse.presentation.decoration.ProductDecoration
import com.example.perfomanceissuse.presentation.recycli.PoolHolder
import com.example.perfomanceissuse.presentation.recycli.category.CategoryItem3

@RecyclerItemView
class CategoryItem3View @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0,
) : LinearLayout(context, attrs, defStyleAttrs), CategoryItem3.View {

    private val binding = ItemCategory3RecycliBinding.inflate(LayoutInflater.from(context), this)
    private val adapter = RecyclerAdapter()

    init {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        elevation = 10f
        setBackgroundResource(R.color.yellow_light)
        orientation = VERTICAL

        binding.recyclerProducts.apply {
            clipChildren = false
            this.adapter = this@CategoryItem3View.adapter
            addItemDecoration(ProductDecoration())
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            setRecycledViewPool(PoolHolder.productViewPool)
        }

    }

    @RecyclerItemStateBinder
    override fun bindState(state: CategoryItem3.State) {
        binding.title.text = state.title
        adapter.bindState(state.products)
    }

}
