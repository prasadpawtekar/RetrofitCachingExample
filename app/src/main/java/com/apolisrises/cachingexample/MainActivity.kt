package com.apolisrises.cachingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.apolisrises.cachingexample.adapters.TrackAdapter
import com.apolisrises.cachingexample.data.ApiService
import com.apolisrises.cachingexample.data.Repository
import com.apolisrises.cachingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvTracks.layoutManager = LinearLayoutManager(baseContext)
        initViewModel()
        setupObservers()

        binding.btnSearch.setOnClickListener {
            viewModel.search(binding.etSearch.text.toString())
        }
    }

    fun initViewModel() {
        val repository = Repository(ApiService.getApiService(applicationContext))
        val factory = MainVMFactory(repository)

        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    fun setupObservers() {
        viewModel.searchResult.observe(this) {
            val adapter = TrackAdapter(it)
            binding.rvTracks.adapter = adapter
        }
    }


}