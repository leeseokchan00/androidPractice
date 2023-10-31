package com.example.myapplication.presentation.main.page2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentResult2Binding


class Result2Fragment : Fragment() {
    lateinit var binding: FragmentResult2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResult2Binding.inflate(inflater, container, false)
        return binding.root

        binding.btPage2Submit.setOnClickListener {  }
    }
}
