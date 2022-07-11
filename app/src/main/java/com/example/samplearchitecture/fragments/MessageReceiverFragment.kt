package com.example.samplearchitecture.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.samplearchitecture.R
import com.example.samplearchitecture.viewmodel.SharedViewModel

class MessageReceiverFragment : Fragment(R.layout.message_receiver_fragment) {
    val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        sharedViewModel.data.observe(this, {
            Log.e("MessageReceiver", "onActivityCreated: $it")
        })
    }

}