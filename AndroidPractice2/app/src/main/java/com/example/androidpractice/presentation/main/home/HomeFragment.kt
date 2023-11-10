package com.example.androidpractice.presentation.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentHomeBinding
import com.example.androidpractice.model.RecyclerData
import com.example.androidpractice.util.fragment.AlertDialogFragment

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //임시데이터를 어뎁터에 넣고 변수로 만듦
        val itemList = ArrayList<RecyclerData>()
        for (i: Int in 1..100) {   //
            itemList.add(RecyclerData("22:01", i.toString(), "이석찬"))
        }

        boardAdapter()

        
        //더미데이터
        homeAdapter.submitList(itemList)   //sublist로 어뎁터에 리스트를 넘겨줌
        binding.rvRecycler1.adapter = homeAdapter   // 리사이클러뷰에 리스트어뎁터 연결
        binding.rvRecycler1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        //레이아웃매니저로 뷰에 나타날 방식 정하기
        // requireContext() : Fragment의 context를 가져오기 위해서는 this 대신 requireContext() 사용
        return binding.root


    }


    fun boardAdapter() {
        homeAdapter = HomeAdapter(
            onLongClicked = { friend ->
                showFriendDialogFragment(friend.title)
                //다이얼로그 생성
            },
            onClicked = { friend ->
                Toast.makeText(requireContext(), "클릭", Toast.LENGTH_SHORT).show()
            }
        )
        binding.rvRecycler1.adapter = homeAdapter
    }

    fun showFriendDialogFragment(title: String) {
        val dialog = AlertDialogFragment.newInstance(
            getString(R.string.home_alert_title),
            getString(R.string.home_alert_negative_label),
            getString(R.string.home_alert_positive_label),
            handlerNegativeButton = {},
            handlerPositiveButton = {
                Toast.makeText(requireContext(),"삭제됨", Toast.LENGTH_SHORT).show()
            })
        dialog.show(parentFragmentManager, "친구삭제키값")
    }
}