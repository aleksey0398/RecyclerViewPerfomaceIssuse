package com.example.perfomanceissuse.presentation.recycli

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.detmir.recycli.adapters.RecyclerAdapter
import com.example.perfomanceissuse.MainActivityViewModel
import com.example.perfomanceissuse.databinding.ActivityRecycliBinding
import com.google.android.material.snackbar.Snackbar

class RecycliActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecycliBinding

    private val viewModel: MainActivityViewModel by viewModels()

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
            addItemDecoration(
                object : RecyclerView.ItemDecoration() {

                }
            )
        }
    }

    private fun setupToolbar(){
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
