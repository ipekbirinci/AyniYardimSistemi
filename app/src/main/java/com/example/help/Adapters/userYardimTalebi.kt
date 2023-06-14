package com.example.help.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.help.R
import com.example.help.RowClickListener
import com.example.help.databinding.ActivityOfferHelpBinding
import com.example.help.databinding.CardCellBinding
import com.example.help.network.data.RequestData
import com.example.help.network.data.RequestResponse
import com.example.help.network.data.RequestResponseData
import com.example.help.network.response.Help


class YardimTalebiAdapter(
    private var requestList: List<Help>,
    private var editClickListener: RowClickListener<Help>,
    private var deleteClickListener: RowClickListener<Help>
) : RecyclerView.Adapter<YardimTalebiAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardCellBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CardCellBinding = DataBindingUtil.inflate(inflater, R.layout.card_cell, parent, false)
        return ViewHolder(binding)
        
        //5063650575
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentHelp = requestList[position]

        holder.binding.tarih.text = currentHelp.requestDate


        holder.binding.duzenle.setOnClickListener {
            editClickListener.onRowClick(position, currentHelp)
        }

        holder.binding.sil.setOnClickListener {
            deleteClickListener.onRowClick(position, currentHelp)
        }


        when (currentHelp.requestType.trim()) {

            HelpType.KIYAFET.name -> {
                //holder.binding.albumpicture.background = R.drawable.clean_hands
            }

            HelpType.SU.name -> {

            }

            HelpType.ISITICI.name -> {

            }

            HelpType.ÇADIR.name -> {

            }

            HelpType.İLAÇ.name -> {

            }

            HelpType.UYKUTULUMU.name -> {

            }

            HelpType.YİYECEK.name -> {

            }

            HelpType.HİJYENMALZEMESİ.name -> {

            }

            HelpType.ELEKTRONİK.name -> {

            }


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
        HİJYENMALZEMESİ,
        ELEKTRONİK
    }
}
