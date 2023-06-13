package com.example.help.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.help.ListingHelp.ListingActivity
import com.example.help.OfferHelp.OfferHelp
import com.example.help.R
import com.example.help.ResetPassword.ResetPasswordActivity
import com.example.help.dataBinding
import com.example.help.databinding.ActivityLoginBinding
import com.example.help.map.MapActivity
import com.example.help.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by dataBinding(R.layout.activity_login)
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        listeners()
        observeViewModel()


    }

    private fun observeViewModel(){

        loginViewModel.isLoginSuccessData.observe(this){

            val success = it.success
            val id = it.id
            if(success){
              //  burada sayfa atlayacakgetus
                Log.d("itsuccess","sucess: ${it.success}")
                val sharedPreferences= getSharedPreferences("userId", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val userId = it.id
                editor.putString("userId", userId)
                editor.apply()
                val intent = Intent(this, OfferHelp::class.java)
                startActivity(intent)
            }

        }
    }


    private fun listeners() {
        binding.button.setOnClickListener {

            val phone = binding.editTextPhone.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            loginViewModel.login(phone, password)

        }
        binding.yeniuye.setOnClickListener{
            //yeni üye butonu
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.sifreicin.setOnClickListener{
            //şifremi unuttum butonu
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
    }

}
