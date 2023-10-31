package com.example.perfomanceissuse.presentation.vanilla

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perfomanceissuse.MainActivityViewModel
import com.example.perfomanceissuse.databinding.ActivityVanillaBinding
import com.example.perfomanceissuse.presentation.decoration.CategoryDecoration
import com.google.android.material.snackbar.Snackbar

class VanillaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVanillaBinding

    private val viewModel: MainActivityViewModel by viewModels()

    private val adapter = VanillaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVanillaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbarTitle()
        setupRecyclerView()
        subscribe()
    }

    private fun setupRecyclerView() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)

            adapter = this@VanillaActivity.adapter

            addItemDecoration(CategoryDecoration())
        }
    }

    private fun setupToolbarTitle() {
        supportActionBar?.title = "Vanilla"
    }

    private fun subscribe() {
        viewModel.stateList.observe(this, adapter::submitList)

        viewModel.errorStateList.observe(this) {
            Snackbar.make(binding.root, it.message.toString(), Snackbar.LENGTH_SHORT).show()
        }
    }
}
