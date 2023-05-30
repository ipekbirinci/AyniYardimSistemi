package com.example.ayniyardim.ui.SignUp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ayniyardim.RegisterActivity
import com.example.ayniyardim.ResetEmail
import com.example.ayniyardim.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val SignUpViewModel =
            ViewModelProvider(this).get(SignUpViewModel::class.java)

        var _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val root: View = _binding.root

        // val textView: TextView = binding.textView2


        //SlideshowViewModel.text.observe(viewLifecycleOwner) {
        //     textView.text = it
        //}
        val myClickableText: TextView = _binding.yeniuye
        val myOtherClickableText: TextView =_binding.sifreicin
        myClickableText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        myOtherClickableText.setOnClickListener {
            val intent = IntentTwo(this, ResetEmail::class.java)
            startActivity(intent)
        }
        return root
    }

    private fun Intent(SignUpFragment: SignUpFragment, clazz: Class<RegisterActivity>): Intent {
        return Intent(SignUpFragment.requireContext(), clazz)
    }
    private fun IntentTwo(SignUpFragment: SignUpFragment, clazz: Class<ResetEmail>): Intent {
        return Intent(SignUpFragment.requireContext(), clazz)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
