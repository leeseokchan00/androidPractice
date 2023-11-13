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
import com.example.androidpractice.model.FriendEntity
import com.example.androidpractice.presentation.main.home.addfriend.AddFriendActivity
import com.example.androidpractice.util.fragment.AlertDialogFragment
import com.example.androidpractice.util.getParcelable
import kotlinx.coroutines.runBlocking

class HomeFragment : Fragment() {
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    lateinit var binding: FragmentHomeBinding
    lateinit var homeAdapter: HomeAdapter
    lateinit var db: FriendDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        db = Room.databaseBuilder(requireContext(), FriendDatabase::class.java, "friend_table")
            .build()

        Adapter()
        initResultLaucher()
        getFriendList()
        initFloatingBtnClickListener()

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
        binding.rvRecycler1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    fun showFriendDialogFragment(id: Int?) {
        val dialog = AlertDialogFragment.newInstance(
            getString(R.string.home_alert_title),
            getString(R.string.home_alert_negative_label),
            getString(R.string.home_alert_positive_label),
            handlerNegativeButton = {},
            handlerPositiveButton = {
                deleteUser(id)
            })
        dialog.show(parentFragmentManager, "친구삭제키값")
    }

    fun deleteUser(id: Int?) {
        var itemList = runBlocking {
            db.friendDao().delete(id)
        }
        getFriendList()
    }

    fun initFloatingBtnClickListener() {
        binding.fbAddFriend.setOnClickListener {
            val intent = Intent(requireContext(), AddFriendActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    fun initResultLaucher() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                var itemList = FriendData.toFriendEntity(
                    result.data?.getParcelable(
                        "addFriend",
                        FriendData::class.java
                    )
                )
                runBlocking {
                    db.friendDao().insertFriend(itemList)
                }
                getFriendList()
            }
        }
    }

    fun getFriendList() {
        val itemList = runBlocking {
            db.friendDao().getAll()
        }
        homeAdapter.submitList(FriendEntity.toFriend(itemList))
    }
}