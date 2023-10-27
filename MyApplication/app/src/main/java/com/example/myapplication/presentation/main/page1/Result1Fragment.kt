package com.example.myapplication.presentation.main.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentResult1Binding
import model.RecyclerData


class Result1Fragment : Fragment() {

    lateinit var binding: FragmentResult1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResult1Binding.inflate(inflater, container, false)

        //임시데이터를 어뎁터에 넣고 변수로 만듦
        val itemList = ArrayList<RecyclerData>()
        for(i: Int in 1.. 100) {   //
            itemList.add(RecyclerData("22:01", i.toString(), "이석찬"))
        }
        val boardAdapter = UserAdapter()


        boardAdapter.submitList(itemList)   //sublist로 어뎁터에 리스트를 넘겨줌
        binding.rvRecycler1.adapter = boardAdapter   // 리사이클러뷰에 리스트어뎁터 연결
        binding.rvRecycler1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        //레이아웃매니저로 뷰에 나타날 방식 정하기
        // requireContext() : Fragment의 context를 가져오기 위해서는 this 대신 requireContext() 사용

        return binding.rvRecycler1.rootView
    }
}