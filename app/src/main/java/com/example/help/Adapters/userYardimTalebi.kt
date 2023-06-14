package com.example.help.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.help.R
import com.example.help.databinding.ActivityOfferHelpBinding
import com.example.help.databinding.CardCellBinding
import com.example.help.network.data.RequestData
import com.example.help.network.data.RequestResponse
import com.example.help.network.data.RequestResponseData


class YardimTalebiAdapter(private var requestList: ArrayList<RequestData>) : RecyclerView.Adapter<YardimTalebiAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardCellBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CardCellBinding = DataBindingUtil.inflate(inflater, R.layout.card_cell, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRequest = requestList[position]
        holder.binding.



    }

    override fun getItemCount(): Int = requestList.size
}
