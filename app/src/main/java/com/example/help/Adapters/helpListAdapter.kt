package com.example.help.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.help.R
import com.example.help.RowClickListener
import com.example.help.databinding.CardCellBinding
import com.example.help.databinding.ListCellBinding
import com.example.help.network.ListResponse.ListHelp
import com.example.help.network.response.Help


class listingAdapter(
    private var requestList: List<ListHelp>,
    private var detailClickListener: RowClickListener<ListHelp>,
) : RecyclerView.Adapter<listingAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListCellBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListCellBinding = DataBindingUtil.inflate(inflater, R.layout.list_cell, parent, false)
        return ViewHolder(binding)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentHelp = requestList[position]

        holder.binding.tarih.text= currentHelp.requestDate
        holder.binding.listyardimturu.text=currentHelp.requestType


        holder.binding.detailButton.setOnClickListener {
            detailClickListener.onRowClick(position, currentHelp)
        }


        val backgroundResId = when (currentHelp.requestType.trim()) {
            HelpType.KIYAFET.name -> R.drawable.shopping_cart
            HelpType.SU.name -> R.drawable.local_drink
            HelpType.ISITICI.name -> R.drawable.sunny
            HelpType.ÇADIR.name -> R.drawable.house_24
            HelpType.İLAÇ.name -> R.drawable.shopping_cart
            HelpType.UYKUTULUMU.name -> R.drawable.seat
            HelpType.YİYECEK.name -> R.drawable.flatware
            HelpType.CleaningMaterials.name -> R.drawable.clean_hands
            HelpType.ELEKTRONİK.name -> R.drawable.iphone_24
            else -> 0
        }

        if (backgroundResId != 0) {
            holder.binding.listyardim.setBackgroundResource(backgroundResId)
        }
    }

    override fun getItemCount(): Int = requestList.size

    enum class HelpType {
        KIYAFET,
        SU,
        ISITICI,
        ÇADIR,
        İLAÇ,
        UYKUTULUMU,
        YİYECEK,
        CleaningMaterials,
        ELEKTRONİK
    }
}


