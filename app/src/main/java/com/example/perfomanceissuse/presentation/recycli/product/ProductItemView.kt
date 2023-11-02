package com.example.perfomanceissuse.presentation.recycli.product

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.perfomanceissuse.R
import com.example.perfomanceissuse.databinding.ItemProductRecycliBinding

@RecyclerItemView
class ProductItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defAttrs), ProductItem.View {

    private val binding = ItemProductRecycliBinding.inflate(LayoutInflater.from(context), this)

    init {
        Log.d("prefetch", "Create new product")

        layoutParams = LayoutParams(
            400,
            LayoutParams.WRAP_CONTENT
        )
        elevation = 10f
        setBackgroundResource(R.drawable.rounded)
        val padding = 20
        setPadding(padding, padding, padding, padding)
    }

    @RecyclerItemStateBinder
    override fun bindState(state: ProductItem.State) {
        Log.d("prefetch", "onBind product(${state.id})")
        binding.textViewProductName.text = state.name
        binding.price.bindState(state.priceState)
        binding.button.bindState(state.buttonState)
//        binding.imageView.load(state.imageUrl)
    }
}
