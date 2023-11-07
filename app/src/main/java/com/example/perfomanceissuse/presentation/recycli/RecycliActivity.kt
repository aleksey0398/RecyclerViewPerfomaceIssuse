package com.example.perfomanceissuse.presentation.recycli

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.detmir.recycli.adapters.RecyclerAdapter
import com.example.perfomanceissuse.databinding.ActivityRecycliBinding
import com.example.perfomanceissuse.presentation.decoration.CategoryDecoration
import com.google.android.material.snackbar.Snackbar
import vivid.money.prefetchviewpool.core.bindToLifecycle
import vivid.money.prefetchviewpool.coroutines.setupWithPrefetchViewPool

class RecycliActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecycliBinding

    private val viewModel: RecycliViewModel by viewModels()

    private val adapter: RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycliBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setUpRecyclerView()
        subscribe()
    }

    private fun setUpRecyclerView() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@RecycliActivity.adapter
            addItemDecoration(CategoryDecoration())
        }
        binding.recycler.setupWithPrefetchViewPool {
            setPrefetchBound(1, 5)
            setPrefetchBound(2, 5)
            setPrefetchBound(3, 5)
        }.bindToLifecycle(this)
    }

    private fun setupToolbar() {
        supportActionBar?.title = "Recycli"
    }

    private fun subscribe() {
        viewModel.stateList.observe(this) {
            adapter.bindState(it)
        }
        viewModel.errorStateList.observe(this) {
            Snackbar.make(binding.root, it.message.toString(), Snackbar.LENGTH_SHORT).show()
        }
    }

}
