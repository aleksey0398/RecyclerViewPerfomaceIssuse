package com.example.perfomanceissuse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.perfomanceissuse.databinding.ActivityMainBinding
import com.example.perfomanceissuse.presentation.recycli.RecycliActivity
import com.example.perfomanceissuse.presentation.vanilla.VanillaActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    public fun openVanilaActivity(view: View) {
        startActivity(Intent(this, VanillaActivity::class.java))
    }

    public fun openRecycliActivity(view: View) {
        startActivity(Intent(this, RecycliActivity::class.java))
    }
}
