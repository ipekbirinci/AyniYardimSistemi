package com.example.help.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.help.R
import com.example.help.network.data.RequestResponse
import com.example.help.network.data.RequestResponseData

class YardimTalebiAdapter(private val itemList: RequestResponse) :
    RecyclerView.Adapter<YardimTalebiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_cell, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        // Verileri kullanarak UI bileşenlerini güncelleyin
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // UI bileşenlerini burada tanımlayın

        fun bind(item: RequestResponseData) {
            // Verileri kullanarak UI bileşenlerini güncelleyin
            // Örneğin, item'dan yardım türü ve konum bilgisi alarak UI bileşenlerini güncelleyebilirsiniz

        }
    }
}
