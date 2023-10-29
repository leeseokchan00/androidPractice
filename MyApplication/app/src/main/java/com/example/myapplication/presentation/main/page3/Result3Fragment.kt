package com.example.myapplication.presentation.main.page3

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentResult3Binding


class Result3Fragment : Fragment() {
    lateinit var binding: FragmentResult3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResult3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btPage3.setOnClickListener {
            val sharedpreferences = requireActivity().getSharedPreferences("loginState", AppCompatActivity.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedpreferences.edit()
            editor.clear()
            editor.apply()
        }
    }

}
