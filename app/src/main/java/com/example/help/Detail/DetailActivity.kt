package com.example.help.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityDetailBinding
import com.example.help.network.ListResponse.ListHelp

class DetailActivity : AppCompatActivity() {
    private val binding : ActivityDetailBinding by dataBinding(R.layout.activity_detail)
    private val detailActivityViewModel : DetailActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detay=intent.getStringArrayExtra("details")
        val time=intent.getStringExtra("zaman")
        val yardimturu=intent.getStringExtra("type")
        val miktar=intent.getStringExtra("quantity")



        binding.detaystring.text = detay.toString()
        binding.miktardetay.text = miktar.toString()
        binding.yardimdetayyardimturu.text = yardimturu.toString()
        binding.tarihdetay.text = time.toString()
        val drawableResId = getDrawableResourceIdForDetailType(yardimturu.toString())
        binding.yardimdetayicon.setImageDrawable(ContextCompat.getDrawable(this@DetailActivity, drawableResId))



    }

    private fun observeDetailData(requestId:String) {
        detailActivityViewModel.detailData.observe(this) { helpList ->
            helpList?.let {
               // val requestId = intent.getStringExtra("requestId") // Intent'ten request ID'yi aldım
                val help = helpList.find { it._id == requestId }
                help?.let {
                    binding.detaystring.text = help.requestDetails
                    Log.d("detay","${help.requestDetails}")
                    binding.miktardetay.text = help.requestQuantity
                    binding.yardimdetayyardimturu.text = help.requestType
                    binding.tarihdetay.text = help.requestDate
                    val drawableResId = getDrawableResourceIdForDetailType(help.requestType)
                    binding.yardimdetayicon.setImageDrawable(ContextCompat.getDrawable(this@DetailActivity, drawableResId))
                }
            }
        }
    }



    private fun getDrawableResourceIdForDetailType(detailType: String): Int {
        // Detay türüne göre drawable kaynağının resourceId'sini döndür
        return when (detailType) {
            "HIJYEN MALZEMESİ" -> R.drawable.clean_hands
            "YİYECEK" -> R.drawable.flatware
            "HIJYEN MALZEMESİ" -> R.drawable.hospital
            "ÇADIR" -> R.drawable.house_24
            "UYKUTULUMU" -> R.drawable.seat
            "SU" -> R.drawable.local_drink
            "KIYAFET" -> R.drawable.shopping_cart
            "ISITICI" -> R.drawable.sunny


            // Diğer detay türlerine göre durumları burada ekleyin
            else -> R.drawable.detail // Varsayılan durum için bir ikon ayarlayabilirsiniz
        }
    }
}