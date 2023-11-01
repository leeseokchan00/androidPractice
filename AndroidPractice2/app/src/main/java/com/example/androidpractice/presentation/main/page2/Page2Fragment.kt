package com.example.androidpractice.presentation.main.page2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidpractice.databinding.FragmentPage2Binding

class Page2Fragment : Fragment() {
    lateinit var binding: FragmentPage2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPage2Binding.inflate(inflater, container, false)
        return binding.root

        binding.btPage2Submit.setOnClickListener { }
    }
}