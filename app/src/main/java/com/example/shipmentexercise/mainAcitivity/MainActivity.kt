package com.example.shipmentexercise.mainAcitivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shipmentexercise.databinding.ActivityMainBinding
import com.example.shipmentexercise.mainAcitivity.adapter.DriverListAdapter
import com.example.shipmentexercise.mainAcitivity.adapter.OnClickListener
import com.example.shipmentexercise.mainAcitivity.model.Driver
import com.example.shipmentexercise.mainAcitivity.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mAdapter: DriverListAdapter
    private val mainViewModel: MainViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupRecyclerView()
    }

    private fun setupViewModel() {
        mainViewModel.getAllDrivers()
        mainViewModel.getAllShipments()
        mainViewModel.driverModel.observe(this, { driverList ->
            mAdapter.submitList(driverList)
        })
    }

    private fun setupRecyclerView() {
        mAdapter = DriverListAdapter(this)
        mLinearLayoutManager = LinearLayoutManager(this)
        binding.driversRecyclerView.apply {
            layoutManager = mLinearLayoutManager
            adapter = mAdapter
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onClick(driver: Driver) {
        mainViewModel.calculateSS(driver)
        mAdapter.notifyDataSetChanged()
    }
}