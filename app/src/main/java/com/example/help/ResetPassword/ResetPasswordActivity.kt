package com.example.help.ResetPassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {
    private val binding: ActivityResetPasswordBinding by dataBinding(R.layout.activity_reset_password)
    private val resetPasswordViewModel : ResetPasswordViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
    }
}