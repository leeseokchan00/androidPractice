package com.example.androidpractice.presentation.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentHomeBinding
import com.example.androidpractice.model.FriendData
import com.example.androidpractice.model.FriendDatabase
import com.example.androidpractice.presentation.main.home.AddFriend.AddFriendActivity
import com.example.androidpractice.util.fragment.AlertDialogFragment
import com.example.androidpractice.util.getParcelable

class HomeFragment : Fragment() {
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    lateinit var binding: FragmentHomeBinding
    lateinit var homeAdapter: HomeAdapter
    lateinit var itemList : ArrayList<FriendData>
    lateinit var db:FriendDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        db = Room.databaseBuilder(requireContext(), FriendDatabase::class.java, "friend").build()
        Adapter()
        initResultLaucher()
        initFloatingBtnClickListener()


        //더미데이터
        itemList = ArrayList<FriendData>()
        for (i: Int in 1..100) {   //
            itemList.add(FriendData("22:01", i, "이석찬"))
        }
        homeAdapter.submitList(itemList)   //sublist로 어뎁터에 리스트를 넘겨줌
        submitList(itemList)

        return binding.root
    }
    fun Adapter() {
        homeAdapter = HomeAdapter(
            onLongClicked = { friend ->
                showFriendDialogFragment(friend.id)
                //다이얼로그 생성
            },
            onClicked = { friend ->
                Toast.makeText(requireContext(), "클릭", Toast.LENGTH_SHORT).show()
            }
        )
        binding.rvRecycler1.adapter = homeAdapter
    }

    fun showFriendDialogFragment(id: Int) {
        val dialog = AlertDialogFragment.newInstance(
            getString(R.string.home_alert_title),
            getString(R.string.home_alert_negative_label),
            getString(R.string.home_alert_positive_label),
            handlerNegativeButton = {},
            handlerPositiveButton = {
                //Toast.makeText(requireContext(), "삭제됨", Toast.LENGTH_SHORT).show()
                deleteUser(id,itemList)
            })
        dialog.show(parentFragmentManager, "친구삭제키값")
    }

    fun deleteUser(id: Int, itemList: ArrayList<FriendData>) {
        if(id != null){
            itemList.removeAt(id-1)
            submitList(itemList)
        }
    }
    fun submitList(itemList: ArrayList<FriendData>){
        homeAdapter.submitList(itemList)
        binding.rvRecycler1.adapter = homeAdapter   // 리사이클러뷰에 리스트어뎁터 연결
        binding.rvRecycler1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    fun initFloatingBtnClickListener(){
        binding.fbAddFriend.setOnClickListener{
            val intent = Intent(requireContext(), AddFriendActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
    fun initResultLaucher(){
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                val v = result.data?.getParcelable("addFriend", FriendData::class.java)
                //db.friendDao().insertFriend(v)
            }
        }
    }
}