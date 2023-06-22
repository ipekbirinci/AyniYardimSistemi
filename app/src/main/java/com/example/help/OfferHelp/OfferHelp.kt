package com.example.help.OfferHelp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.help.Adapters.YardimTalebiAdapter
import com.example.help.NewRequest.NewRequest
import com.example.help.R
import com.example.help.RowClickListener
import com.example.help.dataBinding
import com.example.help.databinding.ActivityOfferHelpBinding
import com.example.help.network.data.RequestDataList
import com.example.help.network.data.RequestResponse
import com.example.help.network.data.RequestResponseDataList
import com.example.help.network.response.Help

class OfferHelp : AppCompatActivity() {

    private val binding: ActivityOfferHelpBinding by dataBinding(R.layout.activity_offer_help)
    private val offerHelpViewModel: OfferHelpViewModel by viewModels ()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_help)

        init()
        listeners()
        observeViewModels()
    }

    private fun init() {

        val sp = getSharedPreferences("userId", Context.MODE_PRIVATE)
        val userId =sp.getString("userId", "test")
        Log.d("userid","${userId}")

        if(userId!=null){
            offerHelpViewModel.getRequestByUser(userId)
        }


    }

    private fun observeViewModels() {

        offerHelpViewModel.helpListData.observe(this) { helpList ->

            val adapter = YardimTalebiAdapter(helpList, editClickListener = object : RowClickListener<Help> {
                override fun onRowClick(pos: Int, item: Help) {
                    Log.d("ClickedEdit", item.requestDate)
                    //güncelleme yapacak
                    //intent ile bir paremetre yolla isUpdated-> boolean olcak, true ise o sayfadaki değişmesini istemediğim parametreleri disabled yapcam
                    //adet ve açıklama açık kalacak yani diğerleri görünürlüğü olmayacak
                    //göndereceğim parametre için data class oluştur sadece detail sadece miktar yada sadece detay ikisi de olabilir
                    //data class nullable da olabilir

                }
            }, deleteClickListener = object : RowClickListener<Help> {
                override fun onRowClick(pos: Int, item: Help) {
                    Log.d("ClickedDelete", item.requestDate)
                    //silece
                  offerHelpViewModel.deleteRequest(item._id)
                  //yeni listi adaptere at ve yeniden adapteri çağır
                    offerHelpViewModel.getRequestByUser(item.userId)

                }
            }
            )
            binding.yardimtalebiolusturview.adapter = adapter
            binding.yardimtalebiolusturview.layoutManager = LinearLayoutManager(this@OfferHelp)

            helpList.forEach { help: Help ->
                Log.d("DataHelp", help.requestDate)

            }
        }
    }

    private fun listeners() {
        binding.button3.setOnClickListener {
            //bu yeni yardım talep et
            val intent = Intent(this, NewRequest::class.java)
            startActivity(intent)


        }

    }


}