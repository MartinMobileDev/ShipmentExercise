package com.example.shipmentexercise.mainAcitivity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shipmentexercise.R
import com.example.shipmentexercise.databinding.ItemDriverBinding
import com.example.shipmentexercise.mainAcitivity.model.Driver

class DriverListAdapter(private var listener: OnClickListener) :
    ListAdapter<Driver, RecyclerView.ViewHolder>(DriverDiffCallback()) {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_driver, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val driver = getItem(position)
        with(holder as ViewHolder){
            setListener(driver)
            binding.tvDriver.text = driver.name
            binding.tvShipment.text = driver.shipment
            binding.tvScore.text = driver.score?.toString().orEmpty()
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemDriverBinding.bind(view)

        fun setListener(driver: Driver){
            with(binding.root) {
                setOnClickListener { listener.onClick(driver) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class DriverDiffCallback : DiffUtil.ItemCallback<Driver>() {
        override fun areItemsTheSame(oldItem: Driver, newItem: Driver): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Driver, newItem: Driver): Boolean {
            return oldItem == newItem
        }

    }
}