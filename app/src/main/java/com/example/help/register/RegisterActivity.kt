package com.example.help.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.help.OfferHelp.OfferHelp
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityRegisterBinding
import com.example.help.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private val binding: ActivityRegisterBinding by dataBinding(R.layout.activity_register)
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        listeners()
       observeViewModel()
    }

    private fun observeViewModel(){

        registerViewModel.isRegisterSuccessData.observe(this){
            if(it){
                //burda intent
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun listeners() {

        binding.button.setOnClickListener {
            val phone = binding.editTextPhone.text.toString()
            val email=binding.editEmail.text.toString()
            val name=binding.editTextTextPersonName.text.toString()
            val password=binding.editTextTextPassword.text.toString()
            registerViewModel.addUser(name, phone, email, password)
        }
    }
}