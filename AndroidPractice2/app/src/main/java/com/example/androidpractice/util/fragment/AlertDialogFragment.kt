package com.example.androidpractice.util.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.androidpractice.databinding.FragmentAlertDialogBinding

class AlertDialogFragment : DialogFragment() {
    lateinit var binding: FragmentAlertDialogBinding
    private var handlerNegativeButton: (()-> Unit)? = null
    private var handlerPositiveButton: (()-> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlertDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.setCanceledOnTouchOutside(false)
        //다이얼로그 영역 밖을 터치했을때만 dismiss 되지 않게, back키를 눌렀을때는 dismiss

        val title = arguments?.getString(ARG_TITLE)
        val negativeButtonLabel = arguments?.getString(ARG_NEGATIVE_BUTTON_LABEL)
        val positiveButtonLabel = arguments?.getString(ARG_POSITIVE_BUTTON_LABEL)

        if(title!=null && negativeButtonLabel != null && positiveButtonLabel != null){
            initDialogText(title, negativeButtonLabel, positiveButtonLabel)
        }
        initNegativeButtonClickListener(handlerNegativeButton)
        initpositiveButtonClickListener(handlerPositiveButton)
    }


    fun initDialogText(
        title: String,
        negativeButtonLabel: String,
        positiveButtonLabel: String
    ){
        binding.tvAlertFragmentTitle.text = title
        binding.tvAlertFragmentNegative.text = negativeButtonLabel
        binding.tvAlertFragmentPositive.text = positiveButtonLabel
    }

    private fun initNegativeButtonClickListener(handlerNegativeButton: (() -> Unit)?){
        binding.tvAlertFragmentNegative.setOnClickListener {
            handlerNegativeButton?.invoke()
            dismiss()
        }
    }

    private fun initpositiveButtonClickListener(handlerPositiveButton: (() -> Unit)?){
        binding.tvAlertFragmentPositive.setOnClickListener {
            handlerPositiveButton?.invoke()
            dismiss()
        }
    }

    companion object {
        //한번 만들어둔 dialog를 다시 사용할 수 도 있기 때문에 fragmentAlertDialog를 초기화해주기 위한 키값
        private const val ARG_TITLE = "title"
        private const val ARG_NEGATIVE_BUTTON_LABEL = "negativeButtonLabel"
        private const val ARG_POSITIVE_BUTTON_LABEL = "positiveButtonLabel"

        fun newInstance(
            // fragment생성을 위한 newInstance
            title: String,
            negativeButtonLabel:String,
            positiveButtonLabel:String,
            handlerNegativeButton: () -> Unit,
            handlerPositiveButton: () -> Unit
        ): AlertDialogFragment {
            val arg = Bundle()
            //bundle로 키값을 저장해서 생성할때 반환해줌
            arg.putString(ARG_TITLE, title)
            arg.putString(ARG_NEGATIVE_BUTTON_LABEL, negativeButtonLabel)
            arg.putString(ARG_POSITIVE_BUTTON_LABEL,positiveButtonLabel)

            val fragment = AlertDialogFragment()
            fragment.arguments = arg

            fragment.handlerNegativeButton = handlerNegativeButton
            fragment.handlerPositiveButton = handlerPositiveButton

            return fragment
        }
    }
}